<template>
  <div class="home">
    <GmapMap
      :center="userPos"
      :zoom="15"
      :options="{
        zoomControl: false,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: false,
        disableDefaultUi: false,
        mapId: '5bad73ddd2112653',
      }"
      map-type-id="roadmap"
      style="width: 100vw; height: 93vh"
      @click="closeMenuView"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in $store.state.filteredMarkers"
        :ref="`marker${index}`"
        :position="m.position"
        :icon="`http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=${
          index + 1
        }|FF0000|FFFFFF`"
        :clickable="true"
        :draggable="false"
        @click="openMarker(index)"
      >
        <GmapInfoWindow
          class="info-window"
          :closeclick="true"
          @closeclick="openMarker(null)"
          :opened="openMarkerId === index"
        >
          <div id="body">
            <router-link
              :to="{ name: 'location-details', params: { id: m.id } }"
            >
              <div id="location-name">{{ m.name }}</div>
            </router-link>

            <div id="location-address">{{ m.address }}</div>
            <img
              id="location-img"
              :src="`http://localhost:8080/api/photos/Philadelphia ${m.name}`"
              alt=""
            />
            <div id="location-buttons">
              <div id="directions">
                <div class="dropdown-container">
                  <b-form-select
                    v-model="travelMode"
                    :options="options"
                    @change="setTravelMode"
                  ></b-form-select>
                </div>
                <button
                  class="btn-midnight-green"
                  :class="{ active: isDirectionsShowing }"
                  @click="showDirections(m.position)"
                >
                  DIRECTIONS
                </button>
              </div>              
              <button
                class="btn-midnight-green"
                @click="
                  checkIn(
                    {
                      userId: $store.state.user.id,
                      locationId: m.id,
                      isCheckedIn: true,
                    },
                    m.position,
                    m.category
                  )
                
                "
                :disabled="m.isCheckedIn"
              >
                {{ m.isCheckedIn ? "CHECKED-IN" : "CHECK-IN" }}
              </button>

              <!-- <div>
                <b-button 
                variant="success"
                @click="checkIn() === true">
                New Badge - Send true

                </b-button>
              </div> -->

              <div 
                id="check-in-far" 
                class="alert alert-danger" 
                role="alert" 
                v-show="m.isTooFar && isHidden == false" @click="hideAlert"
                >
                You're too far from this location!
                <span href="#" id="close">&times;</span>
              </div>

            </div>
          </div>
        </GmapInfoWindow>
      </GmapMarker>
      <GmapMarker
        :position="this.$store.state.userPos"
        :icon="require('../assets/user-location_50.png')"
      ></GmapMarker>
      <DirectionsRenderer
        :travelMode="travelMode"
        :origin="startLocation"
        :destination="endLocation"
      />
    </GmapMap>
    <filter-results></filter-results>
    <menu-button v-show="$store.state.isMenuButtonShowing"></menu-button>
    <Transition name="slide">
      <menu-view v-show="$store.state.isMenuViewShowing"></menu-view>
    </Transition>
  </div>
</template>

<script>
import MenuButton from "../components/MenuButton.vue";
import MenuView from "../components/MenuView.vue";
import LocationService from "../services/LocationService";
import FilterResults from "../components/FilterResults.vue";
import DirectionsRenderer from "../components/DirectionsRenderer.js";
import CheckInService from "../services/CheckInService";

export default {
  name: "home",
  methods: {
    closeMenuView() {
      if (this.$store.state.isMenuViewShowing) {
        this.$store.commit("MENU_TOGGLE");
      }
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.userPos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
        this.$store.commit("SET_USER_POSITION", this.userPos);
      });
    },
    openMarker(id) {
      this.openMarkerId = id;
      this.isCheckedIn = false;
    },
    setPlace(place) {
      this.currentPlace = place;
    },
    showDirections(destination) {
      this.toggleDirections();
      this.startLocation = this.userPos;
      this.endLocation = destination;
    },
    setTravelMode(travelMode) {
      this.travelMode = travelMode;
    },
    toggleDirections() {
      const dir = this.$route.query.dir;
      if (dir == "true" || dir == true) {
        this.$router.push({ name: "home", query: { dir: false } });
      } else {
        this.$router.push({ name: "home", query: { dir: true } });
      }
      this.isDirectionsShowing = !dir;
    },
    checkIn(checkIn, locationPos, category) {
      // check if user is within location range
      if (this.checkUserDistance(locationPos, category)) {
        CheckInService.createCheckin(checkIn).then((response) => {
          if (response.status === 200 || response.status === 201) {
            // success code here
            this.$store.commit("CHECK_IN", checkIn.locationId);
            // display for successful-checkin
            console.log("check-in successful");
          } else {
            // display for when check-in exists already
            console.log("check-in already exists");
          }
          if (response.data === true) {
            console.log("Nice, new badge.")
          }
        });
      } else {
        this.$store.commit("SET_IS_TOO_FAR", checkIn.locationId)
        console.log("Too far from location");
      }
    },
    checkUserDistance(locationPos, category) {
      // 1 km = ~0.01 degrees
      // average Philadelphia park size = 0.0145687 kms
      const parkRange = 0.0015;
      const range = 0.001;
      const isParkLatNear =
        locationPos.lat - this.$store.state.userPos.lat <= parkRange &&
        locationPos.lat - this.$store.state.userPos.lat >= -parkRange;
      const isParkLngNear =
        locationPos.lng - this.$store.state.userPos.lng <= parkRange &&
        locationPos.lng - this.$store.state.userPos.lng >= -parkRange;

      const isLatNear =
        locationPos.lat - this.$store.state.userPos.lat <= range &&
        locationPos.lat - this.$store.state.userPos.lat >= -range;
      const isLngNear =
        locationPos.lng - this.$store.state.userPos.lng <= range &&
        locationPos.lng - this.$store.state.userPos.lng >= -range;

      const isInParkRange =
        category.includes("Park") && isParkLatNear && isParkLngNear;
      const isInRange = !category.includes("Park") && isLatNear && isLngNear;

      return isInParkRange || isInRange;
    },
    hideAlert(){
      this.isHidden = !this.isHidden;
    }
  },
  components: {
    MenuButton,
    MenuView,
    FilterResults,
    DirectionsRenderer,
  },
  data() {
    return {
      userPos: {
        lat: 0,
        lng: 0,
      },
      openMarkerId: null,
      startLocation: this.$store.state.userPos,
      endLocation: this.$store.state.endLocation,
      currentPlace: null,
      travelMode: "WALKING",
      options: [
        { value: "WALKING", text: "Walk" },
        { value: "TRANSIT", text: "Transit" },
      ],
      isDirectionsShowing: false,
      placeImage: null,
      currentLocationId: 0,
      currentUserId: this.$store.state.user.id,
      isCheckedIn: false,
      checkedInLocations: [],
      isHidden: false,
    };
  },
  mounted() {
    this.geolocate();
  },
  created() {
    // get data from API
    LocationService.getAllLocations().then((response) => {
      this.$store.commit("LOAD_LOCATIONS", response.data);
      this.$store.commit("LOAD_NEARBY_LOCATIONS");
    });
    // set marker check-ins to API value
    CheckInService.getAllCheckIns().then((response) => {
      this.$store.commit("SET_CHECK_IN_STATUS", response.data);
    });
  },
  computed: {
    getUserPos() {
      return this.userPos;
    },
  },
};
</script>

<style scoped>
#location-name {
  font-weight: bold;
  color: rgb(0, 73, 83);
  font-size: 24px;
}

#location-address {
  color: rgb(0, 73, 83);
}

#body {
  display: grid;
  padding: 20px;
  text-align: center;
  place-content: center;
  justify-content: center;
}

#location-img {
  max-width: 240px;
  margin: auto;
  padding: 10px;
}

#location-buttons {
  display: flex;
  gap: 10px;
  flex-direction: column;
  align-items: center;
  flex-shrink: 2;
}

#directions {
  display: flex;
  flex-direction: column;
  gap: 10px;
  align-items: center;
}

button.active {
  background-color: rgb(0, 73, 83);
  color: white;
}
button:disabled {
  background-color: rgb(0, 73, 83);
  color: white;
}
</style>

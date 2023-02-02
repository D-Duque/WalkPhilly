<template>
  <div class="home">
    
    <!-- <div>
      <table>
        <tr>
          <th>Start Location</th>
          <th><GmapAutocomplete @place_changed="setPlace" /></th>
          <th style="width: 50%;"><button class="btn" @click="addMarker(0)">Add</button></th>
        </tr>
        <tr>
          <th>End Location</th>
          <th><GmapAutocomplete @place_changed="setPlace" /></th>
          <th style="width: 50%;"><button class="btn" @click="addMarker(1)">Add</button></th>
        </tr>
      </table>
    </div> -->

    <GmapMap
      :center=userPos
      :zoom="15"
      :options="{
        zoomControl: false,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: false,
        disableDefaultUi: false,
        mapId: '5bad73ddd2112653'
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
        :icon="`http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=${index + 1}|FF0000|FFFFFF`"
        :clickable="true" :draggable="false" @click="openMarker(index)">
        <GmapInfoWindow
        :closeclick="true"
        @closeclick="openMarker(null)"
        :opened="openMarkerId === index">
         <div id="location-name"> {{m.name}}</div>
           <div id="location-address"> {{m.address}}</div>
        </GMapInfoWindow>
      </GmapMarker>
      <DirectionsRenderer
        travelMode="WALKING"
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
import DirectionsRenderer from "../components/DirectionsRenderer.js"

// let dS = new google.maps.DirectionsService();
// let dD = new google.maps.DirectionsRenderer();

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
      this.openMarkerId = id
    },
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker(index) {
      const marker = {
        lat: this.currentPlace.geometry.location.lat(),
        lng: this.currentPlace.geometry.location.lng(),
      };
      if (index === 0) this.startLocation = marker;
      if (index === 1) this.endLocation = marker;
      this.center = marker;
    },

  },
  components: {
    MenuButton,
    MenuView,
    FilterResults,
    DirectionsRenderer

  },
  data() {
    return {
      userPos: {
        lat: 0,
          lng: 0,
      },
      openMarkerId: null,
      startLocation: null,
      endLocation: null,
      currentPlace: null,
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
  },
  computed: {
    // nearbyMarkers() {
    //   const markers = this.$store.state.locations
    //     .map((location) => {
    //       return {
    //         name: location.name,
    //         position: {
    //           lat: location.latitude,
    //           lng: location.longitude,
    //         },
    //       };
    //     })
    //     .filter((location) => {
    //       const range = 0.01;
    //       const isLatNear =
    //         location.position.lat - this.userPos.lat <= range &&
    //         location.position.lat - this.userPos.lat >= -range;
    //       const isLngNear =
    //         location.position.lng - this.userPos.lng <= range &&
    //         location.position.lng - this.userPos.lng >= -range;

    //       return isLatNear && isLngNear;
    //     });
    //   return markers;
    // },
    getUserPos() {
      return this.userPos;
    },
  },
};
</script>

<style scoped>
#location-name, #location-address {
  font-weight: bold;
  color: black;
}
</style>

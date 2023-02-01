<template>
  <div class="home">
    <GmapMap
      :center="{ lat: 39.9526, lng: -75.1652 }"
      :zoom="15"
      :options="{
        zoomControl: false,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: false,
        disableDefaultUi: false
      }"
      map-type-id="roadmap"
      style="width: 100vw; height: 93vh"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in $store.state.filteredMarkers"
        :position="m.position"
        :clickable="true"
        :draggable="false"
        @click="center = m.position"
      >
        <GMapInfoWindow>
          <div>I am in info window</div>
        </GMapInfoWindow>
      </GmapMarker>
    </GmapMap>
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

export default {
  name: "home",
  methods: {
    openCloseMenu() {
      this.isMenuButtonShowing = !this.isMenuButtonShowing;
      this.isMenuViewShowing = !this.isMenuViewShowing;
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.userPos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
        this.$store.commit("SET_USER_POSITION", this.userPos);
      });
    }
  },
  components: {
    MenuButton,
    MenuView
  },
  data() {
    return {};
  },
  mounted() {
    this.geolocate();
  },
  created() {
    // get data from API
    LocationService.getAllLocations().then(response => {
      this.$store.commit("LOAD_LOCATIONS", response.data);
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
    }
  }
};
</script>

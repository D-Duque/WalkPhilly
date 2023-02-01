<template>
  <div class="home">
    <GmapMap
      :center="{ lat: 39.9526, lng: -75.1652 }"
      :zoom="13"
      :options="{
        zoomControl: false,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: false,
        disableDefaultUi: false,
      }"
      map-type-id="roadmap"
      style="width: 100vw; height: 93vh"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in filteredMarkers"
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
    <menu-button v-show="$store.state.isMenuButtonShowing"> </menu-button>
    <menu-view v-show="$store.state.isMenuViewShowing">I AM MENU</menu-view>
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
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.userPos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
  },
  components: {
    MenuButton,
    MenuView,
  },
  data() {
    return {};
  },
  mounted() {
    this.geolocate();
  },
  created() {
    // get data from API
    LocationService.getAllLocations().then((response) => {
      this.$store.commit("LOAD_LOCATIONS", response.data);
    });
  },
  computed: {
    filteredMarkers() {
      const markers = this.$store.state.locations.map((location) => {
        return {
          position: {
            lat: location.latitude,
            lng: location.longitude,
          },
        };
      });
      return markers;
    },
    getUserPos() {
      return this.userPos;
    },
    nearbyFilter() {
      let center = {
        lat: 47.0,
        lng: -122.0,
      };

      const isLatNear =
        center.lat - this.userPos.lat <= 1 &&
        center.lat - this.userPos.lat >= -1;
      const isLngNear =
        center.lng - this.userPos.lng <= 1 &&
        center.lng - this.userPos.lng >= -1;
        
      return isLatNear && isLngNear;
    },
  },
};
</script>

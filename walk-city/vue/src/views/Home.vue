<template>
  <div class="home">
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
    }
  },
  components: {
    MenuButton,
    MenuView,
    FilterResults,

  },
  data() {
    return {
      userPos: {
        lat: 0,
          lng: 0,
      },
      openMarkerId: null,
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

<style>
 div {
  color: black;
}
#location-name {
  font-weight: bold;
}
</style>

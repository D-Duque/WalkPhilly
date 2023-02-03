<style src="../components/locationdetail/locationDetail.css" scoped />

<template>
  <div class="main">
    <div id="location-card">
      <h2 id="location-name">{{ location.locationName }}</h2>
      <div class="cooler-line"></div>
      <img id="location-image" src="../assets/harpers-garden.png" alt="" />
      <div id="location-buttons">
        <button class="btn-darker-midnight-green">CHECK-IN</button>
        <button
          class="btn-darker-midnight-green"
          @click.prevent="setLocation({lat: location.latitude, lng: location.longitude})"
        >
          DIRECTIONS
        </button>
      </div>
      <div id="location-description">
        <p>
          {{ location.description }}
        </p>
        <h4>Current Hours:</h4>
        <p>{{ location.availability }}</p>
      </div>
      <img @click="goBack" id="back-button" src="../assets/back-arrow.png" />
    </div>
  </div>
</template>

<script>
import locationService from "../services/LocationService";
export default {
  name: "location-details",
  components: {
  },
  props: [],
  methods: {
    goBack() {
      this.$router.push({name: 'home'});
    },
    setLocation(location) {
      this.$router.push({name: 'home', query: {dir: true}});
      this.$store.commit("SET_END_LOCATION", location);
      
      
    }
  },
  data() {
    return {
      location: { 
      },
    };
  },
  created() {
    locationService.getLocationById(this.$route.params.id).then((response) => {
      this.location = response.data;
    });
  },
  computed: {
    
  },
};
</script>

<style>
#location-description {
  color: rgb(0, 73, 83);
  margin-top: 0px !important;
}
</style>

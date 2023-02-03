<style src="../components/locationdetail/locationDetail.css" scoped />

<template>
  <div class="main">
    <img src="../assets/map-background.png" alt="">
    <div id="location-card">
      <h2 id="location-name">{{location.locationName}}</h2>
      <div class="cool-line"></div>
    </div>

  </div>
</template>

<script>
import locationService from "../services/LocationService"
export default {
  name: "location-details",
  components: {

  },
  props: [],
  data() {
    return {
      location: {}
    };
  },
  created() {
    locationService.getLocationById(this.$route.params.id).then(response => {
      this.location = response.data;
    })
  },
  computed: {
  
  }
};
</script>

<style>
</style>

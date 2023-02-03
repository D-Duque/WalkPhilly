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
          @click="showDirections(m.position)"
        >
          DIRECTIONS
        </button>
      </div>
      <div id="location-description">
        <p>
          Description of the location and the hours. This is beautifcul location
          where lots of things happen and stuff yeah.
        </p>
        <p>Current Hours:</p>
        <p>Monday: 9:00am - 5:00pm</p>
      </div>
      <img @click= "goBack" id="back-button" src="../assets/back-arrow.png" />
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
      this.$router.push({name: 'home'})
    }
  },
  data() {
    return {
      location: {},
    };
  },
  created() {
    locationService.getLocationById(this.$route.params.id).then((response) => {
      this.location = response.data;
    });
  },
  computed: {},
};
</script>

<style>
</style>

<template>
  <div>
    <div class="locations">
      <location-display
        v-for="location in this.$store.state.filteredMarkers"
        v-bind:key="location.id"
        v-bind:location="location"
      />
    </div>
    <div class="back-button">
      <router-link id="back-button" to="/">
        <img src="../assets/back-arrow.png" />
      </router-link>
    </div>
  </div>
</template>

<script>
import LocationDisplay from "../components/LocationDisplay";

export default {
  name: "location-list",
  components: {
    LocationDisplay
  },
  created(){
    // returns the user to the map view after refreshing list view
    if(this.$store.state.filteredMarkers.length == 0)
    {
      this.$router.push("/")
    }
  },
  computed: {}
};
</script>

<style scoped>
.locations {
  margin: 0;
  height: 90vh;
  overflow: auto;
  border-radius: 6px;
}

.back-button {
  position: relative;
  top: 0.5rem;
}
</style>

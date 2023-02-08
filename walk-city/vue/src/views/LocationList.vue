<template>
  <div class="locations">
    <location-display
      v-for="location in this.$store.state.filteredMarkers"
      v-bind:key="location.id"
      v-bind:location="location"
    />
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
  computed: {}
};
</script>

<style scoped>
.back-button {
  position: relative;
  bottom: 10px;
  left: 10px;
}
</style>

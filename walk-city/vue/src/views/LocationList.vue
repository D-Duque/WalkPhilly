<template>
  <div class="locations">
    <div>
      <router-link id="back-button" to="/">
        <img src="../assets/back-arrow.png" />
      </router-link>
    </div>
    <location-display
      v-for="location in this.$store.state.filteredMarkers"
      v-bind:key="location.id"
      v-bind:location="location"
    />
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

<style></style>

<template>
  <div class="locations">
    <location-display
      v-for="location in this.$store.state.filteredMarkers"
      v-bind:key="location.id"
      v-bind:location="location"
    />
  </div>
</template>

<script>
import LocationDisplay from "./LocationDisplay";

export default {
  name: "location-list",
  components: {
    LocationDisplay
  },
  computed: {
    // filteredLocations() {
    //   return this.$store.state.filteredMarkers;
    // }
  }
};
</script>

<style>
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.well-display div.well {
  cursor: pointer;
}
</style>

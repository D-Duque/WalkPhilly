<template>
  <div class="form-outline">
    <input type="search" id="search-input" class="form-control" placeholder="Search" aria-label="Search"
      v-model="textFilter" @change="filterMarkers" ref="Search" @click="resetSearch" @keyup.enter="submit" />
  </div>
</template>

<script>
export default {
  name: "search-bar",
  props: [],
  methods: {
    // access nearbyLocations getter and filter from that to get new filter

    // somehow get new filter to store and set results to filteredMarkers in store
    // commit to FILTER_LOCATIONS in computed property, pass list of locations return commit?

    // call filteredMarkers in Home
    filterMarkers() {
      this.$store.state.textFilter = this.textFilter;
      this.$store.commit("FILTER_ALL");
    },
    resetSearch() {
      this.$refs["Search"].value = "";
    },
    submit() {
      this.$store.commit("MENU_TOGGLE");
    }
  },
  data() {
    return {
      textFilter: ""
    };
  },
  mounted() { },
  computed: {}
};
</script>
<style scoped>
.form-outline {
  width: 80%;
}
</style>

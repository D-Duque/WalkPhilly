<template>
  <div class="form-outline">
    <input
      type="search"
      id="search-input"
      class="form-control"
      placeholder="Search"
      aria-label="Search"
      v-model="textFilter"
    />
  </div>
</template>

<script>
export default {
  name: "search-bar",
  props: [],
  methods: {},
  data() {
    return {
      textFilter: "",
    };
  },
  computed: {
    filteredMarkers() {
      return this.nearbyMarkers.filter(marker => marker.name.includes(this.textFilter))
    }
  }
};
</script>
<style scoped>
.form-outline {
  width: 80%;
}
</style>
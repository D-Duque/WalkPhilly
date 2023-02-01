<template>
  <div class="dropdown-container">
    <b-dropdown
      text="Category"
      block
      variant="light"
      class="m-0"
      menu-class="w-100"
      v-model="currentCategory"
      @change="filteredCategories"
    >
      <b-dropdown-item href="#" value="Restaurant">Restaurants</b-dropdown-item>
      <b-dropdown-item href="#">Museums</b-dropdown-item>
      <b-dropdown-item href="#">Bars</b-dropdown-item>
      <b-dropdown-item href="#">Parks</b-dropdown-item>
    </b-dropdown>
  </div>
</template>
<script>
export default {
  name: "dropdown-bar",
  props: [],
  methods: {
    filteredCategories() {
      const filteredLocations = this.$store.getters.nearbyLocations.filter(
        location =>
          location.category
            .toLowerCase()
            .includes(this.currentCategory.toLowerCase()) ||
          location.category == ""
      );
      this.$store.commit("FILTER_LOCATIONS", filteredLocations);
    }
  },
  data() {
    return {
      currentCategory: ""
    };
  }
};
</script>
<style scoped>
.dropdown-container {
  width: 80%;
  margin: 0 auto;
  border-radius: 10px;
}
</style>

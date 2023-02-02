<template>
  <div class="dropdown-container">
    <b-form-select
      v-model.lazy="currentCategory"
      :options="options"
      @change.="filteredCategories"
    ></b-form-select>
  </div>
</template>
<script>
export default {
  name: "dropdown-bar",
  props: [],
  methods: {
    filteredCategories() {
      const filteredLocations = this.$store.getters.nearbyLocations.filter(
        (location) =>
          this.category == "" ||
          location.category
            .toLowerCase()
            .includes(this.currentCategory.toLowerCase())
      );
      this.$store.commit("FILTER_LOCATIONS", filteredLocations);
    },
  },
  data() {
    return {
      currentCategory: "",
      options: [
        { value: "", text: 'Categories' },
        { value: 'Restaurant', text: 'Restaurants' },
        { value: 'Museum', text: 'Museums' },
        { value: 'Bar', text: 'Bars' },
        { value: 'Park', text: 'Parks' }
      ]
    };
  },
};
</script>
<style scoped>
.dropdown-container {
  width: 80%;
  margin: 0 auto;
  border-radius: 10px;
}
</style>

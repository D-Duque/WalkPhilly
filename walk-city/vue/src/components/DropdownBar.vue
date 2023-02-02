<template>
  <div class="dropdown-container">
    <b-form-select v-model="currentCategory" :options="options" @change="filterMarkers"></b-form-select>
  </div>
</template>
<script>
export default {
  name: "dropdown-bar",
  props: [],
  methods: {
    filterMarkers() {
      this.$store.state.currentCategory = this.currentCategory;
      this.$store.commit("FILTER_ALL");
    }
  },
  data() {
    return {
      currentCategory: "",
      options: [
        { value: '', text: 'Categories' },
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

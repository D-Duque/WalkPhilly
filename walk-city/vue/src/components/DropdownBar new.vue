<template>
  <div class="dropdown-container">
    <b-form-select v-model="currentCategory" :options="options"></b-form-select>
  </div>
</template>
<script>
export default {
  name: "dropdown-bar",
  props: [],
  methods: {},
  data() {
    return {
      currentCategory: null,
      options: [
        { value: null, text: 'Categories' },
        { value: 'Restaurant', text: "Restaurants" },
        { value: 'Museums', text: "Museums" },
        { value: 'Bar', text: "Bar" },
        { value: 'Parks', text: 'Parks' }
      ]
    }
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

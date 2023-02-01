<template>
  <div class="dropdown-container">
    <b-dropdown
      text="Category"
      block
      variant="light"
      class="m-0"
      menu-class="w-100"
    >
    <b-dropdown-item href="#">Resturants</b-dropdown-item>
    <b-dropdown-item href="#">Museums</b-dropdown-item>
    <b-dropdown-item href="#">Bars</b-dropdown-item>
    <b-dropdown-item href="#">Parks</b-dropdown-item>
  </b-dropdown>
  </div>
</template>

<script>
export default {
  name: 'dropdown-bar',
  props: [],
  methods: {}

}

</script>
<style scoped>


.dropdown-container {
  width: 80%;
  margin: 0 auto;
  border-radius: 10px;

} 
</style>
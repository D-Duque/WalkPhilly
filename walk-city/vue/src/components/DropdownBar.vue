<template>
  <div class="dropdown">
    <b-dropdown id="dropdown-1" block text="Category" class="m-2" menu-class="w-100" variant="light">
      <b-dropdown-item>Restaurants</b-dropdown-item>
      <b-dropdown-item>Museums</b-dropdown-item>
      <b-dropdown-item>Bars</b-dropdown-item>
      <b-dropdown-item>Parks</b-dropdown-item>
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
.dropdown {
  width: 100%;
  background-color: white;
}
</style>
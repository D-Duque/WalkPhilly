<style src="../components/locationdetail/locationDetail.css" scoped/>


<template>
  <div class="main">
      <h2 id="location-name">{{this.location.name}}</h2>


    <div>
      <router-link class="btn btn-outline-primary" to="/">Back</router-link>
    </div>
    
  </div>
</template>

<script>
export default {
  name: "location-details",
  components: {

  },
  props: ['locations'],
  data() {
    return {};
  },
  created() {},
  computed: {}
};
</script>



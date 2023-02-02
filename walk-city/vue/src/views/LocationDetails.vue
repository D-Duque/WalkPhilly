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
    return {
      // id: 0
    };
  },
  created() {
    // this is the constructor
    // this.id = +this.$route.params.id;
    // this.$store.commit("SET_ACTIVE_PRODUCT", this.id);
  },
  computed: {
    // location() {
    //   return this.$store.getters.location;
    // }
  }
};
</script>



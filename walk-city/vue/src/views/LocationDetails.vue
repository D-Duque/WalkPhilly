<template>
  <div class="main">
    <div>
      <router-link class="btn btn-outline-primary" to="/">Back</router-link>
    </div>
    <location-list />
  </div>
</template>

<script>
import LocationList from "../components/LocationList.vue";

export default {
  name: "location-details",
  components: {
    LocationList
  },
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

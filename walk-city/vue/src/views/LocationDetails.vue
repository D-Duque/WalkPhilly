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
    return {};
  },
  created() {},
  computed: {}
};
</script>

<style src="../components/locationdetail/locationDetail.css" scoped/>


<template>
  <div class="main">
      <h2 id="location-name">{{location.locationName}}</h2>
    
  </div>
</template>

<script>
import locationService from "../services/LocationService"
export default {
  name: "location-details",
  components: {

  },
  props: [],
  data() {
    return {
      location: {
        name: '',
        address: '',
        category: '',

      }
    };
  },
  created() {
    locationService.getLocationById(this.$route.params.id).then(response => {
      this.location = response.data;
    })
  },
  computed: {
  
  }
};
</script>



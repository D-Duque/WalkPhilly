<template>
  <div>
    I am photo playground
    <p>This is your place ID: {{this.$store.state.placeId}}</p>
  </div>
</template>

 
<script >
export default {
  name: "placesLibrary",

  data() {
    return {
      photoJSON: {},
      photoJSONDefault: {},
      placeId: "",
    };
  },
  methods: {
   
  },
  mounted() {

  },

  created() {
    // placesServices.getPhotoReference("12th and Arch Sts., Philadelphia, PA 19107").then((response) => {
    //     this.photoJSON = response.data
    // }),
    //     placesServices.getPhotoReferenceDefault().then((response) => {
    //         this.photoJSONDefault = response.data
    //     })
  },
  // Run Places search for Place ID
  // Use Place ID to run a places details search
  // get PlacePhoto object from details search result
  // use .getUrl on returned PlacePhoto object to get URL
  // implement url in location detail image attribute
};
</script>

<style>
</style>
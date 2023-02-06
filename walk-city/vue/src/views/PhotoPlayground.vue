<template>
  <div>
    <img :src="placeImage" />
  </div>
</template>

<script>
import axios from 'axios';


export default {
  data() {
    return {
      placeImage: ''
    }
  },
  mounted() {
    this.getPlaceImage();
  },
  methods: {
    async getPlaceImage() {
      // try {
      //   const response = await axios.get(`https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJ68aBlEKuEmsRHUA9oME5Zh0&fields=photo&key=AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c`);
      //   this.placeImage = `https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${response.data.result.photos[0].photo_reference}&key=API_KEY`;
      // } catch (error) {
      //   console.error(error);
      // }
      axios.get(`api/photos/Museum of Contemporary Art Australia`).then(response => this.placeImage = response.data)
    }
  }
}
</script>
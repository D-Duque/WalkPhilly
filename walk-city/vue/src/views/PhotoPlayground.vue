<template>
  <div>
    <div class="form-outline">
      <input type="search" id="search-input" class="form-control" placeholder="Search" aria-label="Search"
        v-model="textFilter" @change="getPlaceImage" />
    </div>
    <img :src="placeImage" />
  </div>
</template>

<script>
//import axios from 'axios';


export default {
  data() {
    return {
      placeImage: '',
      textFilter: ''
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
      this.placeImage = `http://localhost:8080/api/photos/${this.textFilter}`
    }
  }
}
</script>

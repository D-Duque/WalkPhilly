<template>
  <div>
    <div class="history">
      <div class="history-card">
        <div id="overlay">
          <img class="absolute" :src="require(`../assets/${categoryImage}.png`)">
        </div>
        <h3>{{ locationObject.locationName }}</h3>
        <h4>
          {{ entry.checkInTime.toString().slice(0, 10) }}
          {{ entry.checkInTime.toString().slice(11, 19) }}
        </h4>
        <img id="verified-img" src="../assets/verified-account.png" />
      </div>

    </div>
  </div>

  <!-- <div id="overlay" :style="{
          backgroundImage: `url(${restaurantIcon})`
        }"> -->

</template>
<script>
import locationService from "../services/LocationService";
import restaurantIcon from "../assets/restaurant-icon.png";
export default {
  components: {},
  data() {
    return {
      locationObject: {},
      restaurantIcon
    };
  },
  props: ["entry"],

  created() {
    locationService.getLocationById(this.entry.locationId).then(response => {
      this.locationObject = response.data;
    });

  },
  computed: {
    categoryImage() {
      return (this.locationObject.category + "-icon").toLowerCase();
    }

  }
};
</script>
<style scoped>
div.history {
  /* border: 1px black solid; */
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  background-color: white;
  color: rgb(0, 73, 83);
  align-items: center;
  align-self: center;
  overflow: hidden;

  /* background-image: url(../assets/park-icon.png); */
  /* background-repeat: no-repeat; */
  /* background-position: */
  /* transform: rotate(32.7deg); */

  /* background: no-repeat; */
}


div.history p {
  margin: 20px;
}

div.history h3 {
  display: inline-block;
  font-size: 1rem;
}

div.history h4 {
  font-size: .7rem;
  margin: 3px;
  margin-left: 1.5rem;
  /* display: flex;
  justify-content: center; */
}

.history-card {
  display: flex;
  /* display: grid;
  grid-template-columns: 2fr 1fr 1fr */
  justify-content: center;
  flex-direction: row;
  place-items: center;

}

#verified-img {
  /* margin-right: 10px; */
  /* justify-self: right; */
  width: 30px;

}

h3 {
  z-index: 1;
}

img.absolute {

  /*
  left: 100%;
  margin-left: -200px;
  position: absolute;*/
}

#overlay {
  /* background-image: url(../assets/museum-icon.png); */
  background-repeat: no-repeat;
  position: relative;
  transform: rotate(32.7deg);
  height: 100px;
  width: 100px;
  margin-left: -45px;
  margin-bottom: -60px;
  margin-top: -80px;


  /* overflow: hidden; */
}
</style>

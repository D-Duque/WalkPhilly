<template>
  <div>
    <div class="history">
      <div class="history-card">
        <div id="overlay">
          <img
            class="absolute"
            :src="require(`../assets/${categoryImage}.png`)"
          />
        </div>
        <div id="text-container">
          <div id="please-work">
            <h3>{{ locationObject.locationName }}</h3>
          </div>
          <h4>
              <div>
              {{ entry.checkInTime.toString().slice(0, 10) }}
              {{ entry.checkInTime.toString().slice(11, 19) }}
              </div>
              <div>
                <img id="verified-img" src="../assets/verified-account.png" />
              </div>
            </h4>
        </div>
      </div>
    </div>
  </div>


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
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  background-color: white;
  color: rgb(0, 73, 83);
  align-items: center;
  align-self: center;
  overflow: hidden;
}

#please-work {
  display: flex;
  flex-direction: column;
  }

div.history p {
  margin: 20px;
}

div.history h3 {
  display: flex;
  font-size: 1.2rem;
}

div.history h4 {
  font-size: 1rem;
  margin: 3px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  max-width: 310vw;
  font-style: italic;
}

#text-container {
  margin-left: 4.5rem;
}

.history-card {
  display: flex;
  flex-direction: column;
  position: relative;

}

#verified-img {
  height: 30px;
  width: 33px;
}

h3 {
  z-index: 1;
}

img.absolute {
  position: absolute;
  background-repeat: no-repeat;
  transform: rotate(32.7deg);
  margin-left: -50px;
  margin-top: -40px;
  margin-bottom: -30px;

  
}

#overlay {
}
</style>

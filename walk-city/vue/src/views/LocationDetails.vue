<style src="../components/locationdetail/locationDetail.css" scoped />

<template>
  <div class="main">
    <div id="location-card">
      <h2 id="location-name">{{ location.locationName }}</h2>
      <div class="cooler-line"></div>
      <img id="location-image" :src="`http://localhost:8080/api/photos/Philadelphia ${location.locationName}`" alt="" />
      <div id="location-buttons">
        <button
          class="btn-darker-midnight-green"
          type="submit"
          @click.prevent="saveCheckIn()"
        >
          CHECK-IN
        </button>
        <button
          class="btn-darker-midnight-green"
          @click.prevent="
            setLocation({ lat: location.latitude, lng: location.longitude })
          "
        >
          DIRECTIONS
        </button>
      </div>
      <div id="location-description">
        <p id="description">{{ location.description }}</p>
        <p id="availability">{{ location.availability }}</p>
        <p>
          <a v-bind:href="location.social" target="_blank">{{
            location.social
          }}</a>
        </p>
      </div>
      <img @click="goBack" id="back-button" src="../assets/back-arrow.png" />
    </div>
  </div>
</template>

<script>
import checkInService from "../services/CheckInService";
import locationService from "../services/LocationService";
export default {
  name: "location-details",
  components: {},
  props: ["checkInId"],
  data() {
    return {
      location: {}
    };
  },
  created() {
    locationService.getLocationById(this.$route.params.id).then(response => {
      this.location = response.data;
    });
  },
  computed: {},
  methods: {
    goBack() {
      this.$router.back(1);
    },
    setLocation(location) {
      this.$router.push({ name: "home", query: { dir: true } });
      this.$store.commit("SET_END_LOCATION", location);
    },
    saveCheckIn() {
      checkInService.createCheckin(this.checkin).then(response => {
        if (response.status === 201) {
          this.$router.push(`/${this.message.topicId}`);
        }
      });
    }
  }
};
</script>

<style>
#location-description {
  color: rgb(0, 73, 83);
  margin-top: 0px !important;
}

</style>

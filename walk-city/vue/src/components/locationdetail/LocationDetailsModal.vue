<template>
  <b-modal
    title="Title"
    :id="`location-details-modal-` + location.id"
    centered
    hide-header
    hide-footer
  >
    <div id="location-card">
      <h2 id="location-name">{{ location.name }}</h2>
      <div class="cooler-line"></div>
      <img
        id="location-image"
        :src="`http://localhost:8080/api/photos/Philadelphia ${location.name}`"
        alt=""
      />
      <div id="location-description">
        <p id="description">{{ location.description }}</p>
        <p id="availability">{{ location.availability }}</p>
        <p>
          <a v-bind:href="location.social" target="_blank">{{
            location.social
          }}</a>
        </p>
      </div>
    </div>
  </b-modal>
</template>
<script>
import checkInService from "../../services/CheckInService";
import locationService from "../../services/LocationService";

export default {
  props: ["location", "checkInId"],
  data() {
    return {
      currentLocation: {},
      isCheckedIn: false,
    };
  },
  created() {
    locationService.getLocationById(this.location.id).then((response) => {
      this.currentLocation = response.data;
    });
  },
  methods: {
    setLocation(location) {
      this.$router.push({ name: "home", query: { dir: true } });
      this.$store.commit("SET_END_LOCATION", location);
    },
    checkIn(checkIn) {
      checkInService.createCheckin(checkIn).then((response) => {
        if (response.status === 200 || response.status === 201) {
          // success code here
          this.isCheckedIn = true;
        }
      });
    },
  },
};
</script>

<style >
#badge-modal-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}
#badge-modal-image {
  width: 40vw;
}
#badge-modal-timestamp {
  font-style: italic;
}
.modal-content {
  background: rgba(23, 19, 19, 0.25) !important;
  backdrop-filter: blur(15px) !important;
  border-radius: 40px !important;
  color: white;
  margin: 1rem;
}
.modal-backdrop {
  opacity: 0.25 !important;
}
.modal-header {
  text-align: center !important;
}
</style>
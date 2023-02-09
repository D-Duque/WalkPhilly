<template>
  <div>
    <div class="location" v-bind:key="location.id">

      <div id="location-detail-link" @click="openLocationDetails(location.id)">
        <h3>{{ location.name }}</h3>

        <h4>{{ location.category }}</h4>
        <img
          id="location-image"
          :src="
            `http://localhost:8080/api/photos/Philadelphia ${location.name}`
          "
          alt=""
        />
        <p id="address">{{ location.address }}</p>
      </div>
      <a id="website" v-bind:href="location.social" target="_blank">{{
        location.social
      }}</a>
      <location-details-modal :location="location" />
    </div>

  </div>
</template>

<script>
import LocationDetailsModal from "../components/locationdetail/LocationDetailsModal.vue"
export default{
  components: {LocationDetailsModal},
  name: "location-display",
  props: ["location"],
  methods: {
    openLocationDetails(id){
      this.$bvModal.show("location-details-modal-" + id);
    }
  },
  computed: {}
};
</script>

<style>
div.location {
  display: grid;
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  background-color: white;
  /* color: blueviolet; */
  align-items: center;
  align-self: center;
}

div.location p {
  margin: 5px;
}

div.location h3 {
  display: inline-block;
}

div.location h4 {
  font-size: 1rem;
}

div.location a {
  color: rgb(0, 73, 83);
  cursor: pointer;
}

div.location a:hover {
  color: #0066cc;
}

#location-image {
  max-width: 70vw;
}

#website {
  margin: 5px;
  overflow-wrap: anywhere;
}
</style>

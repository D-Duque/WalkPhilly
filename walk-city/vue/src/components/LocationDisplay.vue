<template>
  <div>
    <div class="location" v-bind:key="location.id">
      <router-link
        :to="{ name: 'location-details', params: { id: location.id } }"
        style="text-decoration: none"
      >
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
      </router-link>

      <a id="website" v-bind:href="location.social" target="_blank">{{
        location.social
      }}</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "location-display",
  props: ["location"],
  methods: {},
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
  color: rgb(0, 73, 83);
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

#location-image {
  max-width: 80vw;
}

#website {
  margin: 5px;
  overflow-wrap: anywhere;
}
</style>

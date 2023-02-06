<template>
  <router-link
    :to="{ name: 'location-details', params: { id: location.id } }"
    style="text-decoration: none"
  >
    <div
      class="location"
      v-bind:class="{ checking: location.checked }"
      v-bind:key="location.id"
    >  
      <h3>{{ location.name }}</h3>
      <h4>{{ location.category }}</h4>
      <img id="location-image" :src="`http://localhost:8080/api/photos/Philadelphia ${location.name}`" alt="" />
      <p id="description">{{ location.description }}</p>
      <p id="address">{{ location.address }}</p>
      <p id="availability">{{ location.availability }}</p>
      <p>
        <a v-bind:href="location.social" target="_blank">{{
          location.social
        }}</a>
      </p>
    </div>
  </router-link>
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
  margin: 20px;
}

div.location h3 {
  display: inline-block;
}

div.location h4 {
  font-size: 1rem;
}

#description {
  text-align: justify;
}
#location-image {
  max-width: 80vw;

}
</style>

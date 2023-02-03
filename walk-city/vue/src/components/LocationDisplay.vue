<template>
  <div
    class="location"
    v-bind:class="{ checking: location.checked }"
    v-bind:key="location.id"
  >
    <h3>{{ location.name }}</h3>
    <h4>{{ location.category }}</h4>
    <p id="description">{{ location.description }}</p>
    <p id="address">{{ location.address }}</p>
    <p id="availability">{{ location.availability }}</p>

    <p>
      <a v-bind:href="location.social" target="_blank">{{ location.social }}</a>
    </p>
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
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  background-color: white;
  color: rgb(0, 73, 83);
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
</style>

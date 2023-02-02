<template>
  <div
    class="location"
    v-bind:class="{ checking: location.checked }"
    v-bind:key="location.id"
  >
    <h3>{{ location.name }}</h3>

    <h4>{{ location.category }}</h4>
    <p>{{ location.address }}</p>
    <p>{{ location.social }}</p>
    <p>
      Checking?
      <input
        type="checkbox"
        v-bind:checked="location.checked"
        v-on:change="onCheckedChange(location)"
      />
    </p>
  </div>
</template>

<script>
export default {
  name: "location-display",
  props: ["location"],
  methods: {
    onCheckedChange(location) {
      this.$store.commit("FLIP_CHECKED", location);
    }
  }
};
</script>

<style>
div.main div.location {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  background-color: #ffff;
  color: black;
}

div.main div.location.check {
  background-color: lightyellow;
}

div.main div.location p {
  margin: 20px;
}

div.main div.location h3 {
  display: inline-block;
}

div.main div.location h4 {
  font-size: 1rem;
}
</style>

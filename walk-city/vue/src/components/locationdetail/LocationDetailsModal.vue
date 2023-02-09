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
      <div class="cool-line"></div>
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
export default {
  props: ["location"],
};
</script>

<style scoped>
a {
    color: rgb(255 255 255);
    font-weight: bold;
text-decoration: underline;
}
#location-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
#location-image{
    margin: 1rem;
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


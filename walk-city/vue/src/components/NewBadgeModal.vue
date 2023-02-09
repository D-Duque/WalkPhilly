<template>
  <div class="new-badge-container">
  <b-modal 
    id="new-badge-modal" 
    hide-footer
    hide-header
    centered
    text-center>

    <div id="new-badge-details">
      <h2>CONGRATULATIONS!</h2>
      <div class="cool-line"></div>
      <div id="image-badge">
        <img src="../assets/badge.png" width = "150" height = "150">
      </div>
      <h5>You just earned a new badge! Check it out in 'view check-ins' under badges!</h5>
    </div>
  </b-modal>
</div>
</template>

<script>
  export default {
  }
</script>

<style scoped>

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

h2 {
  padding-top: .5rem;
}


#new-badge-details {
  text-align: center;
  display: flex;
  justify-content: center;
  flex-direction: column;
  /* margin: 1rem; */
  align-items: center;
}

#image-badge {
  margin-top: 1rem;
  margin-bottom: 1rem;
}
</style>
<template>
  <div>
  <b-button id="show-btn" @click="$bvModal.show('new-badge-modal')">Open Modal</b-button>

  <b-modal id="new-badge-modal" hide-footer>
    <template #modal-title>
      NEW BADGE
    </template>
    <div class="d-block text-center">
      <h3>Congrats! You earned a new badge!</h3>
    </div>
    <b-button class="mt-3" block @click="$bvModal.hide('new-badge-modal')">Yay!</b-button>
  </b-modal>
</div>
</template>

<script>
  export default {
  //   methods: {
  //     showModal() {
  //       this.$refs['my-modal'].show()
  //     },
  //     hideModal() {
  //       this.$refs['my-modal'].hide()
  //     },
  //     toggleModal() {
  //       // We pass the ID of the button that we want to return focus to
  //       // when the modal has hidden
  //       this.$refs['my-modal'].toggle('#toggle-btn')
  //     }
  //   }
  }
</script>
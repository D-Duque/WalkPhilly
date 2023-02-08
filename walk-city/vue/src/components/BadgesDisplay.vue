<template >
  <div
    class="badge-card"
    :class="{ 'not-earned-card': !isEarned }"
    @click="badgeClicked(badge)"
  >
    {{ badge.badgeName }}
    <img :src="require(`../assets/${badge.badgeImage}.png`)" />
    <b-modal
      :id="`badge-modal-` + badge.badgeId"
      
      centered
      :title="badge.badgeName"
      hide-footer
      hide-header
      text-center
    >
      <div id="modal-details">
        <img :src="require(`../assets/${badge.badgeImage}.png`)" alt="" />
        <p>{{ badge.description }}</p>
      </div>
    </b-modal>
  </div>
</template>
<script>
// import badgesServices from "../services/BadgesServices";

export default {
  // components: {},
  data() {
    return {
      // badgeObject: {},
      name: "",
      image: null,
      description: "",
    };
  },
  props: ["badge", "userBadgeList"],
  methods: {
    badgeClicked: function (badge) {
      this.name = badge.badgeName;
      this.image = badge.badgeImage;
      this.$bvModal.show("badge-modal-" + badge.badgeId);
    },
  },
  mounted() {},
  computed: {
    isEarned() {
      return (
        this.userBadgeList.filter(
          (entry) => entry.badgeId == this.badge.badgeId
        ).length == 1
      );
    },
  },
};
</script>
<style scoped>

div.badge {
  display: grid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  color: rgb(0, 73, 83);
  grid-template-columns: repeat(2, 1fr);
  column-gap: 1rem;
  row-gap: 1rem;
}

div.badge p {
  margin: 20px;
}

div.badge h3 {
  display: inline-block;
}

div.badge h4 {
  font-size: 1rem;
}

.badge-card {
    background: #4fd695;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    width: 150px;
    height: 175px;
    border-radius: 6px;
    display: flex;
    flex-direction: column;
    padding: 1rem;
    color: white;
    font-weight: 100;
    text-align: center;
    font-size: 1rem;

}

#badge-name {
    display: flex;
    align-self: center;
}

.not-earned-card {
  -webkit-filter: grayscale(100%);
}
#modal-details {
    display: flex;
    flex-direction: column;
    align-items: center;
}

</style>
<style >
.modal-backdrop {
    opacity: 0.25 !important;
}
</style>

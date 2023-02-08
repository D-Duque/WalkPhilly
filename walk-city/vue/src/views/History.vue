<template>
  <div id="history-page">
    <div class="buttons">
      <button
        id="check-in-history-button"
        :class="{
          'btn-white-outline': showBadges,
          'btn-midnight-green': !showBadges
        }"
        @click="historyToggle"
      >
        CHECK-IN HISTORY
      </button>
      <button
        id="badges-button"
        :class="{
          'btn-white-outline': !showBadges,
          'btn-midnight-green': showBadges
        }"
        @click="historyToggle"
      >
        BADGES
      </button>
    </div>
    <history-display
      v-for="entry in checkInList"
      v-bind:key="entry.checkInId"
      v-bind:entry="entry"
      v-show="!showBadges"
    ></history-display>
    <div class="badge-container">
      <badges-display
        v-show="showBadges"
        v-for="badge in badgeList"
        v-bind:key="badge.badgeId"
        v-bind:badge="badge"
      >
      </badges-display>
      <div class="back-button">
        <router-link id="back-button" to="/">
          <img src="../assets/back-arrow.png" />
        </router-link>
      </div>
    </div>
  </div>
</template>
<script>
import HistoryDisplay from "../components/HistoryDisplay.vue";
import BadgesDisplay from "../components/BadgesDisplay.vue";
import checkInService from "../services/CheckInService";
import badgesService from "../services/BadgesService";

export default {
  components: {
    HistoryDisplay,
    BadgesDisplay
  },
  data() {
    return {
      showBadges: false,
      checkInList: [],
      badgeList: []
    };
  },
  methods: {
    historyToggle() {
      this.showBadges = !this.showBadges;
    }
  },
  created() {
    checkInService
      .getCheckInsByUserId(this.$store.state.user.id)
      .then(response => {
        this.checkInList = response.data;
      });

    badgesService.getAllBadges().then(response => {
      this.badgeList = response.data;
    });
  }
};
</script>
<style scoped>
.buttons {
  margin-top: 1rem;
  margin-left: 1rem;
  display: flex;
  justify-content: center;
  gap: 1rem;
}

.badge-container {
  display: grid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
  color: rgb(0, 73, 83);
  grid-template-columns: repeat(2, 1fr);
  column-gap: 1rem;
  row-gap: 1rem;
}

.greyscale {
  -webkit-filter: grayscale(100%);
}

.back-button {
  position: relative;
  bottom: 10px;
  left: -1rem;
}
</style>

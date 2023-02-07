<template>
    <div id="history-page">
        <button id="check-in-history-button"
            :class="{ 'btn-darker-midnight-green': !showBadges, 'btn-midnight-green': showBadges }"
            @click="historyToggle">CHECK-IN HISTORY</button>
        <button id="badges-button"
            :class="{ 'btn-darker-midnight-green': showBadges, 'btn-midnight-green': !showBadges }"
            @click="historyToggle">BADGES</button>
        <history-display v-for="entry in checkInList" v-bind:key="entry.checkInId" v-bind:entry="entry"
            v-show="!showBadges"></history-display>
        <badges-display v-show="showBadges"></badges-display>
    </div>
</template>
<script>
import HistoryDisplay from '../components/HistoryDisplay.vue';
import BadgesDisplay from "../components/BadgesDisplay.vue";
import checkInService from '../services/CheckInService';

export default {
    components: {
        HistoryDisplay,
        BadgesDisplay
    },
    data() {
        return {
            showBadges: false,
            checkInList: []
        }
    },
    methods: {
        historyToggle() {
            this.showBadges = !this.showBadges
        }
    },
    created() {
        checkInService.getCheckInsByUserId(this.$store.state.user.id).then(response => {
            this.checkInList = response.data;
        })
    }
}
</script>
<style scoped>

</style>
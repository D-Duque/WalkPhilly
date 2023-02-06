<template>
    <div id="history-page">
        <button id="check-in-history-button" :class="{'btn-darker-midnight-green': !showBadges, 'btn-midnight-green': showBadges}" @click="historyToggle">CHECK-IN HISTORY</button>
        <button id="badges-button" :class="{'btn-darker-midnight-green': showBadges, 'btn-midnight-green': !showBadges}" @click="historyToggle">BADGES</button>
        <history-display v-show="!showBadges"></history-display>
        <badges-display v-show="showBadges"></badges-display>
    </div>
</template>
<script>
import HistoryDisplay from '../components/HistoryDisplay.vue';
import BadgesDisplay from "../components/BadgesDisplay.vue";

export default {
    components: {
        HistoryDisplay,
        BadgesDisplay
    },
    data() {
        return {
            showBadges: false
        }
    },
    methods: {
        historyToggle() {
            this.showBadges = !this.showBadges
        }
    }
}
</script>
<style scoped>

</style>
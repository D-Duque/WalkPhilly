<template>
    <div id="history-page">
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
    }
}
</script>
<style scoped>

</style>
<template>
    <div id="filter-results"
        :class="{ 'filter-on': filteringOn, 'filter-off': !filteringOn, 'one-filter': oneFilter, 'two-filter': twoFilter }">
        <div id="magnifying-glass"><img v-show="twoFilter" src="../assets/search-big.png"><img v-show="oneFilter"></div>
        <div id="text-category-results">
            <div id="text-result">{{ this.$store.state.textFilter }}</div>
            <div id="category-result">{{ this.$store.state.currentCategory }}</div>
        </div>
    </div>
</template>
<script>
export default {
    computed: {
        filteringOn() {
            return this.$store.state.textFilter != '' || this.$store.state.currentCategory != ''
        },
        oneFilter() {
            return (this.$store.state.textFilter != '' && this.$store.state.currentCategory == '') || (this.$store.state.textFilter == '' && this.$store.state.currentCategory != '')
        },
        twoFilter() {
            return this.$store.state.textFilter != '' && this.$store.state.currentCategory != ''
        }
    }
}
</script>
<style scoped>
#filter-results {
    justify-content: center;
    align-items: center;
    font-size: large;
    color: white;
    background: rgba(0, 73, 83, 0.8);
    border: 1px solid #000000;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 40px;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 90%;

}

#text-category-results {
    color: white;
}

.filter-on {
    position: fixed;
    top: 1px;
    font-size: large;
    height: auto;

}

.two-filter {
    display: grid;
    grid-template-columns: 1fr 3fr;
}

.filter-off {
    display: none
}
</style>
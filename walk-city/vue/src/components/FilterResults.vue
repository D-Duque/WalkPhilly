<template>
    <div id="filter-results" :class="{ 'filter-on': filteringOn, 'filter-off': !filteringOn }" @click="menuToggle">
        <img id="big-glass" v-show="twoFilter" src="../assets/search-big.png"><img id="small-glass" v-show="oneFilter"
            src="../assets/search-little.png">
        <div id="text-category-results" :class="{ 'one-filter': oneFilter, 'two-filter': twoFilter }">
            <div id="category-result">{{ this.$store.state.currentCategory }}</div>
            <div id="text-result">{{ this.$store.state.textFilter }}</div>
        </div>
    </div>
</template>
<script>
export default {
    methods: {
        menuToggle() {
            this.$store.commit("MENU_TOGGLE");
        }
    },
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

    justify-content: center;
    align-items: center;
    width: 90%;

}


.filter-on {
    position: fixed;
    top: 1px;
    left: 5%;
    font-size: large;
    height: auto;
    align-self: center;
    margin: 0 auto;
}

img {
    position: absolute;

}

#big-glass {
    margin-left: 1rem;
    margin-top: .5rem;
}


.one-filter {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;

}

.two-filter {
    position: relative;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}

.two-filter>div:nth-child(1) {
    font-weight: bold;
}

.filter-off {
    display: none
}
</style>
<template>
    <div id="filter-results" :class="{ filterOn: filteringOn() }">
        Philly Cheesesteak
    </div>
</template>
<script>
export default {
    methods: {
        filteringOn() {
            return this.$store.state.textFilter != '' || this.$store.state.currentCategory != ''
        },
    }
}
</script>
<style scoped>
#filter-results {

    position: fixed;
    display: flex;
    top: 1px;
    background: #004953;
    justify-content: center;
    align-items: center;
    font-size: x-large;
    width: 361px;
    height: 5%;
    background: rgba(0, 73, 83, 0.8);
    border: 1px solid #000000;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 40px;
}
</style>
<template>
    <!-- <div :class="{
        'menu-filters-on': filteringOn
    }"> -->
    <div @click="menuToggle" id="menu-button">
        MENU
    </div>
    <!-- <div v-if="filteringOn">
            <search-bar></search-bar>
            <dropdown-bar></dropdown-bar>
        </div> -->
    <!-- </div> -->
</template>
<script>
// import DropdownBar from "./DropdownBar.vue";
// import SearchBar from "./SearchBar.vue";

export default {
    name: 'menu-button',
    props: [],
    components: {
        // SearchBar,
        // DropdownBar
    },
    methods: {
        menuToggle() {
            this.$store.commit('MENU_TOGGLE');
        }
    },
    computed: {
        filteringOn() {
            return this.$store.state.textFilter != '' || this.$store.state.currentCategory != ''
        }
    }
}
</script>
<style>
.menu-button {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 7%;
    width: 100%;
    justify-content: center;
    align-items: center;
    font-size: x-large;
}
</style>
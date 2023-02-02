<template>
    <div :class="{
        'menu-filters-on': filteringOn,
        'menu-filters-off': !filteringOn
    }">
        <div @click="menuToggle" id="menu-button">
            MENU
        </div>
        <search-bar v-show="filteringOn"></search-bar>
        <dropdown-bar v-show="filteringOn"></dropdown-bar>
    </div>
</template>
<script>
import DropdownBar from "./DropdownBar.vue";
import SearchBar from "./SearchBar.vue";

export default {
    name: 'menu-button',
    props: [],
    components: {
        SearchBar,
        DropdownBar
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
.menu-filters-off {
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

.menu-filters-on {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 20%;
    width: 100%;
    justify-content: space-around;
    align-items: center;
    font-size: x-large;
    flex-direction: column;

}

/* #menu-button {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 7%;
    width: 100%;
    justify-content: center;
    align-items: center;
    font-size: x-large;


} */
</style>
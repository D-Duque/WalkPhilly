<template>
    <div id="main-menu">
        <div  @click="menuToggle" id="title">Menu</div>
        <search-bar></search-bar>
        <dropdown-bar></dropdown-bar>
        <div id="view-badges">view badges</div>
        <div id= "username">username</div>
        <div id="home-and-logout">home button and log out</div>
        
    </div>
</template>
<script>
import DropdownBar from './DropdownBar.vue';
import SearchBar from './SearchBar.vue'
export default {
    name: 'menu-view',
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

}
</script>

<style>
#main-menu {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 70%;
    width: 100%;
    justify-content: center;
    align-items: center;
    font-size: large;
    flex-direction:column;
}

#title {

}

</style>
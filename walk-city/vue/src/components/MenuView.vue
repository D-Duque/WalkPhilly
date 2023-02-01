<template>
    <div id="main-menu">
        <div  @click="menuToggle" id="title">MENU</div>
        <search-bar></search-bar>
        <dropdown-bar></dropdown-bar>
        <div class="cool-line"></div>
        <div id="view-badges">VIEW BADGES</div>
        <div class="cool-line"></div>
        <div id= "username">USERNAME</div>
        <div id="home-and-logout">
            <div id="back-button">
                <img src="../assets/back-arrow.png">
            </div>
            <button class="btn-midnight-green" id="log-out">LOG OUT</button>
        </div>

        
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
    justify-content: space-around;
    align-items: center;
    font-size: x-large;
    flex-direction:column;

}

#home-and-logout {
    display:flex;
    align-items: center;
    justify-content: space-around;
    width: 100%;

}

/* #view-badges, #username {
    border-bottom: 1px solid #FFFFFF;
    width: 90%;
    text-align: center;
    padding: 2rem;
    margin: 0px;

} */

.cool-line {
    width: 90%;
    height: 1px;
    background-color: white;
}




</style>
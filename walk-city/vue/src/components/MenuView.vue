<template>
  <div id="main-menu">
    <div id="title">MENU</div>
    <search-bar></search-bar>
    <div id="dropdown-container">
      <dropdown-bar></dropdown-bar>
    </div>
    <div class="cool-line"></div>
    <div id="view-badges">{{ $store.state.token != '' ? 'VIEW BADGES' : ' ' }} </div>
    <div class="cool-line">
    </div>
    <div id="username"> {{ $store.state.token != '' ? $store.state.user.username.toUpperCase() : 'GUEST' }}</div>
    <div id="home-and-logout">
      <div @click="menuToggle" id="back-button">
        <img src="../assets/back-arrow.png" />
      </div>


      <button class="btn-midnight-green" id="log-out" v-if="$store.state.token != ''" @click="logoutAndMenuToggle">LOG
        OUT</button>


      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">
        <button class="btn-midnight-green" id="log-out" @click="menuToggle">LOG IN</button>
      </router-link>
    </div>
  </div>
</template>
<script>
import DropdownBar from "./DropdownBar.vue";
import SearchBar from "./SearchBar.vue";
export default {
  name: "menu-view",
  props: [],
  computed: {

  },
  components: {
    SearchBar,
    DropdownBar,
  },
  methods: {
    menuToggle() {
      this.$store.commit("MENU_TOGGLE");
    },
    logout() {
      this.$store.commit("LOGOUT");
    },
    logoutAndMenuToggle() {
      this.menuToggle();
      this.logout();
    }
  },
};
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
  flex-direction: column;
}

#home-and-logout {
  display: flex;
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

#dropdown-container {
  width: 100vw;
  display: flex;

}
</style>

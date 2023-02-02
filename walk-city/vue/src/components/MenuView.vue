<template>
  <div>
    <div :class="{
      'menu-filters-on': filteringOn,
      'menu-filters-off': !filteringOn
    }" v-show="!$store.state.isExpanded">
      <div @click="menuToggle" id="menu-button">
        MENU
      </div>
      <!-- <search-bar v-show="filteringOn"></search-bar>
      <dropdown-bar v-show="filteringOn"></dropdown-bar> -->
    </div>
    <div id="main-menu" v-show="$store.state.isExpanded">
      <div id="title" @click="menuToggle">MENU</div>
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
  </div>
</template>
<script>
import DropdownBar from "./DropdownBar.vue";
import SearchBar from "./SearchBar.vue";
export default {
  name: "menu-view",
  props: [],
  components: {
    SearchBar,
    DropdownBar,
  },
  methods: {
    menuToggle() {
      this.$store.commit("MENU_EXPAND");
    },
    logout() {
      this.$store.commit("LOGOUT");
    },
    logoutAndMenuToggle() {
      this.menuToggle();
      this.logout();
    }
  },
  computed: {
    filteringOn() {
      return this.$store.state.textFilter != '' || this.$store.state.currentCategory != ''
    },
    filteringOnOrExpanded() {
      return this.filteringOn() || this.$store.state.isExpanded
    }
  }
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
</style>

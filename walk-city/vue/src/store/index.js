import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem("token");
const currentUser = JSON.parse(localStorage.getItem("user"));

if (currentToken != null) {
  axios.defaults.headers.common["Authorization"] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || "",
    user: currentUser || {},
    isMenuButtonShowing: true,
    isMenuViewShowing: false,
    locations: [],
    userPos: {},
    textFilter: "",
    currentCategory: "",
    filteredMarkers: [],
    currentMarker: null,
    startLocation: null,
    endLocation: null,
    placeId: ""
  },
  getters: {
    nearbyLocations(state) {
      const locations = state.locations
        .map(location => {
          return {
            id: location.locationId,
            name: location.locationName,
            position: {
              lat: location.latitude,
              lng: location.longitude
            },
            category: location.category,
            address: location.address,
            description: location.description,
            availability: location.availability,
            social: location.socialMedia
          };
        })
        .filter(location => {
          const range = 0.01;
          const isLatNear =
            location.position.lat - state.userPos.lat <= range &&
            location.position.lat - state.userPos.lat >= -range;
          const isLngNear =
            location.position.lng - state.userPos.lng <= range &&
            location.position.lng - state.userPos.lng >= -range;

          return isLatNear && isLngNear;
        });
      return locations;
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem("token", token);
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem("user", JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem("token");
      localStorage.removeItem("user");
      state.token = "";
      state.user = {};
      axios.defaults.headers.common = {};
    },
    MENU_TOGGLE(state) {
      state.isMenuButtonShowing = !state.isMenuButtonShowing;
      state.isMenuViewShowing = !state.isMenuViewShowing;
    },
    LOAD_LOCATIONS(state, locations) {
      state.locations = locations;
    },
    SET_USER_POSITION(state, position) {
      state.userPos = position;
    },
    FILTER_LOCATIONS(state, filteredLocations) {
      state.filteredMarkers = filteredLocations;
    },
    LOAD_NEARBY_LOCATIONS(state) {
      state.filteredMarkers = this.getters.nearbyLocations;
    },
    FLIP_CHECKED(state, locationToChange) {
      locationToChange.checked = !locationToChange.checked;
    },
    FILTER_ALL(state) {
      const filteredLocations = this.getters.nearbyLocations.filter(
        location =>
          location.category
            .toLowerCase()
            .includes(state.currentCategory.toLowerCase()) &&
          location.name.toLowerCase().includes(state.textFilter.toLowerCase())
      );
      state.filteredMarkers = filteredLocations;
    },
    SET_CURRENT_MARKER(state, id) {
      state.currentMarker = id;
    },
    SET_END_LOCATION(state, location) {
      state.endLocation = location;
    },
    SET_PLACE_ID(state, id){
      state.placeId = id;
    }
  }
});

<template>
  <div class="home">
    <GmapMap :center="{ lat: 39.9526, lng: -75.1652 }" :zoom="13" :options="{
      zoomControl: true,
      mapTypeControl: false,
      scaleControl: false,
      streetViewControl: false,
      rotateControl: false,
      fullscreenControl: true,
      disableDefaultUi: false
    }" map-type-id="roadmap" style="width: 100vw; height: 95vh">
      <GmapMarker :key="index" v-for="(m, index) in markers" :position="m.position" :clickable="true" :draggable="true"
        @click="center = m.position">
        <GMapInfoWindow>
          <div>I am in info window
          </div>
        </GMapInfoWindow>

      </GmapMarker>
    </GmapMap>
    <menu-button v-show="$store.state.isMenuButtonShowing"> </menu-button>
    <menu-view v-show="$store.state.isMenuViewShowing">I AM MENU</menu-view>
  </div>
</template>

<script>
import MenuButton from "../components/MenuButton.vue"
import MenuView from "../components/MenuView.vue"

export default {
  name: 'home',
  methods: {
    openCloseMenu() {
      this.isMenuButtonShowing = !this.isMenuButtonShowing;
      this.isMenuViewShowing = !this.isMenuViewShowing
    }
  },
  components: {
    MenuButton,
    MenuView
  },
  data() {
    return {
      markers: [{
        name: 'Liberty Bell',
        position: {
          lat: 39.9496, lng: -75.1503
        }
      },
      {
        name: 'Philadelphia Museum of Art',
        position: {
          lat: 39.9656, lng: -75.1810
        }
      }
      ],

    }
  }

};
</script>

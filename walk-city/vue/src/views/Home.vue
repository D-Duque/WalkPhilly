<template>
  <div class="home">
    <GmapMap
  :center='{lat: 39.9526, lng: -75.1652}'
  :zoom="13"
  :options="{
   zoomControl: true,
   mapTypeControl: false,
   scaleControl: false,
   streetViewControl: false,
   rotateControl: false,
   fullscreenControl: true,
   disableDefaultUi: false
 }"
  map-type-id="roadmap"
  style="width: 100vw; height: 100vh"
>
  <GmapMarker
    :key="index"
    v-for="(m, index) in markers"
    :position="m.position"
    :clickable="true"
    :draggable="false"
    @click="center=m.position"
    >
    <GMapInfoWindow>
        <div>I am in info window 
        </div>
      </GMapInfoWindow>

  </GmapMarker>
</GmapMap>
  </div>
</template>

<script>
export default {
    name: 'home',
    data() {
        return {
          center: { lat: 0.0, lng: 0.0},
          
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
            },
            ]
        }
    },
    mounted() {
      this.geolocate();
    },
    methods: {
      geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
      });
    },
    },

};
</script>

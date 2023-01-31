<template>
  <div class="home">
    <GmapMap
  :center="{lat:39.9526, lng:-75.1652}"
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
    :draggable="true"
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
            ]
        }
    }

}
</script>

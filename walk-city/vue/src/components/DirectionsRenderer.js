import { MapElementFactory } from "vue2-google-maps";

export default MapElementFactory({
  name: "directionsRenderer",

  ctr() {
    return window.google.maps.DirectionsRenderer;
  },

  events: [],

  mappedProps: {},

  props: {
    origin: { type: [Object, Array] },
    destination: { type: [Object, Array] },
    travelMode: { type: String }
  },

  afterCreate(directionsRenderer) {
    let directionsService = new window.google.maps.DirectionsService();

    let displayDirections = () => {
      let { origin, destination, travelMode } = this;
      if (!origin || !destination || !travelMode) return;
      directionsService.route(
        {
          origin,
          destination,
          travelMode
        },
        (response, status) => {
          if (status !== "OK") return;
          // eslint-disable-next-line no-debugger
          // debugger
          directionsRenderer.setDirections(response);
        }
      );
    }

    if(this.$route.query.dir === true)
    {
      displayDirections();
    }

    this.$watch(
      () => [this.origin, this.destination, this.travelMode, this.$route.query.dir],
      () => {
        if (this.$route.query.dir === false)
        {
          directionsRenderer.setDirections({routes: []});
        }
        else {
          displayDirections()
        }
        
       
        // let { origin, destination, travelMode } = this;
        // if (!origin || !destination || !travelMode) return;
        // directionsService.route(
        //   {
        //     origin,
        //     destination,
        //     travelMode
        //   },
        //   (response, status) => {
        //     if (status !== "OK") return;
        //     // eslint-disable-next-line no-debugger
        //     // debugger
        //     directionsRenderer.setDirections(response);
        //   }
        // );
      }
    );
  }
});

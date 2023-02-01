import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from 'vue2-google-maps'

import { BootstrapVue } from 'bootstrap-vue'
Vue.use(BootstrapVue)

// import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;


Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c',
    libraries: 'places',
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


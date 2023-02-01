import axios from 'axios';

export default {

    getAllLocations() {
        return axios.get('/locations')
    },

    getLocationById(locationId) {
        return axios.get(`/locations/${locationId}`)
    },

    getLocationByCategory(category) {
        return axios.get(`/locations/category/${category}`)
    }
}
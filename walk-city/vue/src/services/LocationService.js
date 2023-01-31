import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/locations"
})
export default {

    getAllLocations() {
        return http.get('/')
    },

    getLocationById(locationId) {
        return http.get(`/${locationId}`)
    },

    getLocationByCategory(category) {
        return http.get(`/category/${category}`)
    }
}
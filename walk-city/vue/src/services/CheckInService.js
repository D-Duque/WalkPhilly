import axios from 'axios';

export default {
    getAllCheckIns() {
        return axios.get('/checkins')
    },

    // getCheckInsById() {
    //     return axios.get(`/checkins/${checkInId}`)
    // }
}
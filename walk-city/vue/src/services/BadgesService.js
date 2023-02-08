import axios from "axios";

export default {
    getBadgesByUserId(userId) {
        return axios.get(`/badges/user/${userId}`);
    },

    getBadgesByBadgeId(badgeId) {
        return axios.get(`/badges/badge/${badgeId}`);
    },

}
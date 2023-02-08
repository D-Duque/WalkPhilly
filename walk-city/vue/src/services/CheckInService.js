import axios from "axios";

export default {
  getAllCheckIns() {
    return axios.get("/checkins");
  },

  getCheckInsById(checkInId) {
    return axios.get(`/checkins/checkin/${checkInId}`);
  },

  getCheckInsByUserIdAndLocationID(userId, locationId) {
    return axios.get(`/checkins/user/${userId}/location/${locationId}`);
  },

  createCheckin(checkin) {
    return axios.post("/checkin", checkin);
  },

  getCheckInsByUserId(userId) {
    return axios.get(`/checkins/user/${userId}`);
  }
};

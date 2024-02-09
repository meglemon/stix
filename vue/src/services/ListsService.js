import axios from 'axios';

export default {

  getListsByUserId(userId) {
    return axios.get(`/lists/${userId}`)
  },

}
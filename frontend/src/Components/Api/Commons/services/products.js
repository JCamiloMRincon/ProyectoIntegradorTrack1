import axios from 'axios'
import { BASE_URL } from "../constants/config";

export const getProductById = async(productId) => {
    return await axios.get(`${BASE_URL}productos/${productId}`).then(data => data.data);
}
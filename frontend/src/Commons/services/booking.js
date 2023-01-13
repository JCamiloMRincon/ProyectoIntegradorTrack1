import axios from "axios";
import { BASE_URL } from "../constants/config";

export const booking = async (horaInicial, fechaInicial, fechaFinal, usuarioId) => {
  return await axios
    .post(
      BASE_URL + "reservas  ",
      {
        horaInicial,
        fechaInicial, 
        fechaFinal,
        usuarioId,
      },
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
    .then((response) => {
      console.log(response);
      return response;
    })
    .catch((error) => console.log(error));
};
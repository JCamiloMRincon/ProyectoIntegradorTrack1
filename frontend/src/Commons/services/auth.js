import axios from "axios";
import { BASE_URL } from "../constants/config";

export const login = async (email, password) => {
  return await axios
    .post(
      BASE_URL + "login",
      {
        email,
        contrasenia: password,
      },
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
    .then((response) => {
      return response;
    })
    .catch((error) => console.log(error));
};

export const register = async ({
  email,
  firstName,
  lastName,
  ciudadId = 1,
  password,
}) => {
  return await axios
    .post(
      BASE_URL + "usuarios",
      {
        email,
        nombre: firstName,
        apellido: lastName,
        ciudadId,
        contrasenia: password,
      },
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
    .then((response) => {
      return response;
    })
    .catch((error) => console.log(error));
};

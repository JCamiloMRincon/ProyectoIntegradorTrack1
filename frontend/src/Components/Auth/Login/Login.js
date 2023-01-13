import React, { useState } from "react";
import Header from "../../Header/Header";
import Footer from "../../Footer/Footer";
import Body from "../../Body/Body";
import Input from "../../Commons/Input/Input";
import "./../auth.scss";

import jwt_decode from "jwt-decode";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { login } from "../../../Commons/services/auth";
import { useBookingContext } from "../../../Context/BookingContext";

const Login = () => {
  const [email, setEmail] = useState("");
  const [userExists, setUserExist] = useState(false);
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const [messageUser, setMessageUser] = useState("");
  const { updateUser } = useBookingContext();

  const handleLogin = async (e) => {
    e.preventDefault();
    const result = await login(email, password);

    if (result?.data?.jwt) {
      const data = jwt_decode(result.data.jwt);
      const name = data.name.split(" ");
      updateUser({
        token: result.data.jwt,
        ...data,
        firstName: name[0],
        lastName: name[1],
      });
      navigate("/home");
      return;
    }

    setUserExist(true);
  };

  return (
    <div className="auth">
      <Header className="header"></Header>
      <Body className="container">
        <div className="card-login">
          <h1 className="tittle">Iniciar sesión</h1>
          <form onSubmit={handleLogin}>
            <Input
              label="Correo electrónico"
              type="email"
              onChange={(e) => setEmail(e.target.value)}
              required={true}
            />
            {userExists ? <div className="error">Usuario no existe</div> : ""}
            <div className="error">{messageUser}</div>
            <Input
              label="Contraseña"
              type="password"
              required={true}
              minLength={6}
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <div className="container-button">
              <button onClick={login} className="buttonPrimary" type="submit">
                Ingresar
              </button>
            </div>
            <span className="go-to-register">
              ¿Aún no tienes cuenta?
              <Link to={"/register"}> Registrate</Link>
            </span>
          </form>
        </div>
      </Body>
      <Footer className="footer"></Footer>
    </div>
  );
};

export default Login;
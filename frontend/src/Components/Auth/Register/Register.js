import React, { useState } from "react";
import Footer from "../../Footer/Footer";
import Header from "../../Header/Header";
import Body from "../../Body/Body";
import Input from "../../Commons/Input/Input";
import "./../auth.scss";
import "./Register.scss";
import { Link, useNavigate } from "react-router-dom";
import { validateEmail, validatePassword, validateRePassword } from "../utils";
import { register } from "../../../Commons/services/auth";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";


const Register = () => {
const MySwal = withReactContent(Swal);

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [email, setEmail] = useState("");
  const [errorsMsg, setErrorsMsg] = useState({});
  const navigate = useNavigate();

  const onRegister = async (e) => {
    e.preventDefault();
    const errorEmail = validateEmail(email, setErrorsMsg);
    const errorPassword = validatePassword(password, setErrorsMsg);
    const errorRePassword = validateRePassword(
      password,
      rePassword,
      setErrorsMsg
    );

    if (!errorEmail && !errorPassword && !errorRePassword) {
      const result = await register({
        email,
        firstName,
        lastName,
        password,
      });

      if (result.status === 201) {

        MySwal.fire({
          title: "Registro exitoso!",
          text: "Gracias por inscribirte, ahora debes iniciar sesión",
          icon: "success",
          button: "Aceptar"
        }).then((value) => {
          navigate("/login");
        });
        return;
      } else {
          MySwal.fire({
            title: "¡Oops!",
            text: "Lo sentimos, intenta de nuevo",
            icon: "error",
            button: "Aceptar"
          })
      }
    }
  };

  return (
    <div className="auth">
      <Header className="header"></Header>
      <Body className="container">
        <div className="card-register">
          <h1 className="tittle">Crear cuenta</h1>
          <form onSubmit={onRegister}>
            <div className="full-name">
              <Input
                label="Nombre"
                onChange={(e) => setFirstName(e.target.value)}
                value={firstName}
              />
              <Input
                label="Apellido"
                onChange={(e) => setLastName(e.target.value)}
                value={lastName}
              />
            </div>
            <Input
              label="Correo electrónico"
              value={email}
              type="email"
              onChange={(e) => setEmail(e.target.value)}
              error={errorsMsg.email}
            />
            <Input
              label="Contraseña"
              type="password"
              required={true}
              minLength={6}
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              error={errorsMsg.password}
            />
            <Input
              label="Confirmar contraseña"
              type="password"
              required={true}
              minLength={6}
              value={rePassword}
              onChange={(e) => setRePassword(e.target.value)}
              error={errorsMsg.rePassword}
            />
            <div className="container-button">
              <button className="buttonPrimary" onClick={onRegister}>
                Crear cuenta
              </button>
            </div>
          </form>
          <span className="go-to-register">
            ¿Ya tienes una cuenta?
            <Link to={"/login"}> Iniciar sesión</Link>
          </span>
        </div>
      </Body>
      <Footer className="footer"></Footer>
    </div>
  );
};

export default Register;
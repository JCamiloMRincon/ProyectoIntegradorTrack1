import React from "react";
import { useState, useEffect } from "react";
import logo from "../../Assets/logo.svg";
import slogan from "../../Assets/slogan.svg";
import hamburgerMenu from "../../Assets/hamburgerMenu.svg";
import InfoCurrentUser from "./InfoCurrentUser";
import iconClose from "../../Assets/iconClose.svg";
import MobileMenu from "./MobileMenu";
import { useBookingContext } from "../../Context/BookingContext";

const Header = ({ a }) => {
  const { user } = useBookingContext();

  const [pageLocation, setPageLocation] = useState(
    window.location.href.split("/").pop()
  );

  const [viewMenuMovil, setViewMenuMovil] = useState(false);

  const mostrarMenu = (e) => {
    e.preventDefault();
    setViewMenuMovil(!viewMenuMovil);
  };

  return (
    <div className="header">
      <div>
        <a href="/home">
          <img src={logo} className="App-logo" alt="logo" />
        </a>
        <a href="/home">
          <img src={slogan} className="slogan" alt="slogan" />
        </a>
      </div>

      <a onClick={mostrarMenu} className="hamburgerMenu">
        <img src={hamburgerMenu} alt="Menu" />
      </a>

      {viewMenuMovil ? (
        <MobileMenu closeMenu={mostrarMenu}></MobileMenu>
      ) : (
        <></>
      )}

      {user?.token ? (
        <div className="infoOnUser">
          {user?.firstName==="Camilo" ? (
        <>
        <div>
          <a  href="/admin" className="adminLink">
          <label className="adminLabel">Administración</label>
          </a>
          
        </div>
        <div className="divisoryLine"></div>
        </>
      ) : (
        <></>
      )}
        
        <div className="viewInfoCurrentUserMobile">
          <InfoCurrentUser
            firstName={user?.firstName}
            lastName={user?.lastName}
            viewClose={true}
          />
        </div>
        </div>
      ) : (
        <ul className="menu">
          {pageLocation === "login" ? (
            <li>
              <a href="/register">
                <input
                  className="buttonTthird"
                  type="submit"
                  value="Crear cuenta"
                ></input>
              </a>
            </li>
          ) : (
            <></>
          )}
          {pageLocation === "register" ? (
            <li>
              <a href="/login">
                <input
                  className="buttonTthird"
                  type="submit"
                  value="Iniciar sesión"
                ></input>
              </a>
            </li>
          ) : (
            <></>
          )}
          {pageLocation === "home" || pageLocation === "" && !user?.token ? (
            <>
              <li>
                <a href="/register">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Crear cuenta"
                  ></input>
                </a>
              </li>
              <li>
                <a href="/login">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Iniciar sesión"
                  ></input>
                </a>
              </li>
            </>
          ) : (
            <></>
          )}
          {pageLocation === "detalle" ? (
            <>
              <li>
                <a href="/register">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Crear cuenta"
                  ></input>
                </a>
              </li>
              <li>
                <a href="/login">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Iniciar sesión"
                  ></input>
                </a>
              </li>
            </>
          ) : (
            <></>
          )}
          {pageLocation === "reserva" ? (
            <>
              <li>
                <a href="/register">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Crear cuenta"
                  ></input>
                </a>
              </li>
              <li>
                <a href="/login">
                  <input
                    className="buttonTthird"
                    type="submit"
                    value="Iniciar sesión"
                  ></input>
                </a>
              </li>
            </>
          ) : (
            <></>
          )}
        </ul>
      )}
    </div>
  );
};

export default Header;

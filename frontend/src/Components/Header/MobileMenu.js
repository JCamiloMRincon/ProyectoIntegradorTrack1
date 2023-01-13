import React from 'react';
import { useNavigate } from "react-router-dom";
import iconClose from '../../Assets/iconClose.svg';
import { useState, useEffect } from "react";
import "./MobileMenu.scss";
import InfoCurrentUser from './InfoCurrentUser';
import ListIconsSocialNetworks from '../Footer/ListIconsSocialNetworks';


const MobileMenu = ({closeMenu}) => {
  const [sesion, setSesion] = useState({
    'firstName': "",
    'lastName': "",
    'isActive': false 
  })

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
     setSesion({
      'firstName': user.firstName,
      'lastName': user.lastName,
      'isActive': true
    })
    }else{
      console.log("No hay sesión iniciada")
    }
  }, []);

    const [viewMenuMovil,setViewMenuMovil] = useState(false)
    const mostrarMenu = (e) => {
        e.preventDefault()
        setViewMenuMovil(!viewMenuMovil)
        
    };

    const navigate = useNavigate();

    const logOut = (e) => {
        e.preventDefault()
        window.localStorage.removeItem('currentUser')
        document.location.href = "/home"
    }

  return (
    <div className='containerMenu'>
         <div className='headerHamburger'>
          <a onClick={closeMenu}>
            <img src={iconClose} alt="icon"/>
          </a>
          
          {sesion.isActive?<InfoCurrentUser firstName={sesion.firstName} lastName={sesion.lastName} viewClose={false} /> :<h1>Menú</h1>}
          
        </div>
        { sesion.isActive?<ul >
          <li>
          <a  href="/admin">
          <label>Administración</label>
          </a>
          <hr></hr>
          <a  href="/login">
          <label onClick={logOut}>Cerrar sesion</label>
          </a>
          <hr></hr>
          </li>
          
        </ul>:<ul >
          <li>
          
             <a href="/register">
                Crear cuenta
            </a>
            <hr></hr>
          </li>
          <li>
          
          <a  href="/login">
           Iniciar sesión
          </a>
          <hr></hr>
          </li>
          
        </ul>}
        {/* <InfoCurrentUser></InfoCurrentUser> */}
        <div className='listIcons'>
        {/* { sesion.isActive? <label onClick={logOut}>Cerrar sesion</label>: <></>} */}
        <ListIconsSocialNetworks ></ListIconsSocialNetworks>
        </div>
    </div>
  )
}

export default MobileMenu
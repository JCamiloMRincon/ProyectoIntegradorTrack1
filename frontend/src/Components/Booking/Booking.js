import React from 'react'
import DataBooking from '../DataBooking/DataBooking'
import DetailBooking from '../DetailBooking/DetailBooking'
import DetailHeader from '../DetailHeader/DetailHeader';
import PoliciesBlock from '../ProductPage/PoliciesBlock/PoliciesBlock';
import GenericCalendar from '../ProductPage/Calendar/GenericCalendar';
import './Booking.scss'
import Header from '../Header/Header';
import Footer from '../Footer/Footer';
import { useState, useEffect } from 'react';
import Swal from "sweetalert2";
import { Link, useNavigate } from "react-router-dom";
import withReactContent from "sweetalert2-react-content";
import { useBookingContext } from '../../Context/BookingContext';



const Booking = () => {
  const MySwal = withReactContent(Swal);
  const [monthsShown, setMonthsShown] = useState(2);
  const [productoInfo,setProductoInfo] = useState({});
  const navigate = useNavigate();
  const [productoInfoCategory,setProductoInfoCategory] = useState('');
  
  const { user } = useBookingContext();
  useEffect(() => {
    if(!user.token){
      navigate('/login')
    }
  
    
  }, [user])
  const urlBase = 'http://18.116.203.145:8085/'
  const getProducto = urlBase + 'productos/';

    const [windowDimenion, detectHW] = useState({
        winWidth: window.innerWidth,
        winHeight: window.innerHeight,
      })

  const handleResize = () => {
    detectHW({
        winWidth: window.innerWidth,
        winHeight: window.innerHeight,
      })
  };

  useEffect(() => {
    window.addEventListener("resize", handleResize);

    (windowDimenion.winWidth >= 700 && windowDimenion.winWidth)  ? setMonthsShown(2) : setMonthsShown(1);
    console.log(window.innerWidth);
    return () => {
        window.removeEventListener('resize', handleResize)
      }
  }, [windowDimenion]);

  useEffect(() => {
    let id = JSON.parse(localStorage.getItem('selectedProduct'));
    fetch(getProducto+id)
    .then((response) => response.json())
    .then((producto) => {
      console.log(producto)
          setProductoInfo(producto)
          setProductoInfoCategory(producto.categoria.titulo)
    })
    .catch(function(error) {
        console.log("error")
    });
    
  }, []);

  

  return (
    
    <div>
      <Header />
        <DetailHeader title={productoInfo.titulo || ''} category={productoInfoCategory || ''}/>
        <section className='booking'>
          <DataBooking />
          <DetailBooking />

          <div className='calendar-container'>
            <h1 className='title'>
              Seleccioná tu fecha de reserva
            </h1>
            <GenericCalendar  
            monthsShown={monthsShown} inline >
            </GenericCalendar>
          </div>
          
        </section>
        <PoliciesBlock />
        <Footer/>
    </div>
    
  )
}

export default Booking;
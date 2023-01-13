import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useBookingContext } from "../../../Context/BookingContext";
import GenericCalendar from "../Calendar/GenericCalendar";
import './ReservationsBlock.scss'
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";


const ReservationsBlock = () => {
  const { user } = useBookingContext();
  

    const [monthsShown, setMonthsShown] = useState(2);
    const {updateBooking} = useBookingContext();
    const navigate = useNavigate()
    const MySwal = withReactContent(Swal);


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

  const goToBooking = () => {
    if (!user?.token ) {
      MySwal.fire({
        title: "Ops!",
        text: "Debes iniciar sesión para poder hacer una reserva",
        icon: "cancel",
        button: "Aceptar"
      }).then((value) => {
        navigate("/login");
      });
      
    }
   
    const productId = localStorage.getItem('selectedProduct')
    // asignar id del productos que estas visualizando en la pagina de detalle
    updateBooking({productId, dateStart: '2022-12-01', dateEnd: '2022-12-01'});
    navigate('/reserva')
  }

  useEffect(() => {
    window.addEventListener("resize", handleResize);

    (windowDimenion.winWidth >= 700 && windowDimenion.winWidth)  ? setMonthsShown(2) : setMonthsShown(1);
    console.log(window.innerWidth);
    return () => {
        window.removeEventListener('resize', handleResize)
      }
  }, [windowDimenion]);



    return (
        <div className="reservations-block">
            <h1 className="title">Fechas disponibles</h1>
            <div className="reservations-block__content">
                <GenericCalendar className="reservations-calendar" inline selectsRange={false} monthsShown={monthsShown}></GenericCalendar>
                <div className="reservations-info">
                    <h4 className="reservations-info__title">Agregá tus fechas de viaje para obtener precios exactos</h4>
                    <button className="button-one" type="button" onClick={goToBooking}>Iniciar Reserva</button>
                </div>
            </div>
        </div>
    );
};

export default ReservationsBlock;
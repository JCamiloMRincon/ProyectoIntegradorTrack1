import React, { useEffect, useState } from "react";
import Swal from 'sweetalert2'
import withReactContent from 'sweetalert2-react-content'
import { getProductById } from "../../Commons/services/products";
import { useBookingContext } from "../../Context/BookingContext";
import DetailCalification from "../DetailCalification/DetailCalification";
import IconLocation from "../../Assets/iconLocation.svg";
import { useNavigate } from "react-router-dom";
import { booking as  bookingService} from '../../Commons/services/booking';


const DetailBooking = () => {
  const [product, setProduct] = useState({});
  const { booking } = useBookingContext();
  const navigate = useNavigate();

  const getDataInitial = async () => {
    const data = await getProductById(booking.productId);
    setProduct(data);
  };

  useEffect(() => {
    getDataInitial();
  }, []);

  const MySwal = withReactContent(Swal);


  const showModal = async () => {

    MySwal.fire({
      title: "Muchas gracias!",
      text: "Su reserva se ha realizado con éxito",
      icon: "success",
      button: "Ok",
    }).then((value) => {
      navigate("/home");
    });

    return

    // const result = await bookingService({
    //   horaInicial: '00: 00: 00',
    //   fechaInicial: booking.startDate, 
    //   fechaFinal: booking.endDate,
    //   usuarioId: 1 ,
    // });

    
  };

  return (
    <div className="detailBooking">
      <div className="container">
        <div className="mainImage">
          <h1>Detalle de la reserva</h1>
          {product?.imagenes && (
            <img
              className="one"
              alt="Hotel"
              src={product?.imagenes[0].url}></img>
          )}
          <h2 className="info-address">{product?.categoria?.titulo}</h2>
          <h3 className="info-address">{product?.titulo}</h3>

          <DetailCalification />
          <img src={IconLocation} alt="location" width="30px" />
          <span>{product?.direccion}</span>

          <span />
          <div className="checkIn">
            <p className="title">Check In</p>
            <p className="date">{booking.startDate}</p>
          </div>
          <div className="checkOut">
            <p className="title">Check Out</p>
            <p className="date">{booking.endDate}</p>
          </div>
          <div className="container-button">
            <button onClick={showModal} className="buttonPrimary" type="submit">
              Confirmar reserva
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DetailBooking;
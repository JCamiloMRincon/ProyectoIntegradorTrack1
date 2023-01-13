import React from "react";
import { useState, useEffect, forwardRef } from "react";
import "../../App.scss";
import "./Searcher.scss";
import axios from "axios";

import calendarIcon from "../../Assets/calendarIcon.svg";
import localizador from "../../Assets/localizador.svg";

import GenericCalendar from "../ProductPage/Calendar/GenericCalendar";

const Searcher = (props) => {

  const baseUrl = 'http://18.116.203.145:8085';

  const [optionCities, setOptionCities] = useState([]);

  const [monthsShown, setMonthsShown] = useState(1);

  const [inputValue, setinputValue] = useState();

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

  const handleSelectCity = (e) => {
    var city = e.target.value;
    setinputValue(city)
    console.log(e.target.value);
  }

  const buscarPorCiudad = (e) => {
    props.onSelectCity(inputValue);
  }

  useEffect(() => {
    axios.get(baseUrl + '/ciudades')
    .then((response) => {
      setOptionCities(response.data);
    })
    .catch(function (error) {
      console.log(error);
    });

    window.addEventListener("resize", handleResize);

    (windowDimenion.winWidth >= 700 && windowDimenion.winWidth) ? setMonthsShown(2) : setMonthsShown(1);
    return () => {
      window.removeEventListener('resize', handleResize)
    }
  }, [windowDimenion]);

  const CalendarCustomInput = forwardRef(({ value, onClick }, ref) => (
    <button className="calendarInput input" onClick={onClick} ref={ref}>
      <img
        className="calendarIcon"
        src={calendarIcon}
        alt="Calendar icon"
      ></img>
      <input
        className="inputPrimary"
        placeholder="Check in - Check out"
        value={value}
      ></input>
    </button>
  ));

  return (
    <div className="seeker">
      <h1 className="seekerTitle">
        Busca ofertas en departamentos, casas y mucho más
      </h1>
      <div className="seekerInputs">
        <div className="cityInput input">
          <img
            className="locationIcon"
            src={localizador}
            alt="Location icon"
          ></img>
          <select className="inputPrimary" onChange={handleSelectCity} selected>
            <option value="" disabled selected hidden>
              ¿A dónde vamos?
            </option>
            {optionCities.map((city) => (
              <option key={city.id} value={city.id}>
                {city.nombre}
              </option>
            ))}
          </select>
        </div>

        <GenericCalendar
          customInput={<CalendarCustomInput />}
          monthsShown={monthsShown}
          // onChange={handleCalendar}
        >
          <button type="button" className="button-one calendarButton">
            Aplicar
          </button>
        </GenericCalendar>

        <input type="button" className="button-one" onClick={buscarPorCiudad} value="Buscar"></input>
      </div>
    </div>
  );
};

export default Searcher;

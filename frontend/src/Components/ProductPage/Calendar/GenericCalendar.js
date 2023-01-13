import React from "react";
import { useState, useEffect } from "react";

// import calendarIcon from '../../../Assets/calendarIcon.svg';

import "react-datepicker/dist/react-datepicker.css";
import "./GenericCalendar.scss";
import DatePicker, { registerLocale } from "react-datepicker";
import es from "date-fns/locale/es";
import { useBookingContext } from "../../../Context/BookingContext";
registerLocale("es", es);

// const date = require('date-and-time');

const GenericCalendar = (datepickerProps) => {
  const {updateBooking} = useBookingContext()

  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const onChange = (dates) => {
    const [start, end] = dates;
    setStartDate(start);
    setEndDate(end);
    updateBooking({startDate: start.toLocaleDateString(), endDate: end.toLocaleDateString()})
  };



  return (
    <>
    {/* <div>
      <img src={calendarIcon} alt="Calendar icon"></img>
      <input></input>
    </div> */}
      <div className="calendar-container">
        <DatePicker
          selected={startDate}
          onChange={onChange}
          startDate={startDate}
          endDate={endDate}
          selectsRange
          //   inline
          // disabled
          // monthsShown={2}
          calendarStartDay={0}
          shouldCloseOnSelect={false}
          formatWeekDay={nameOfDay => nameOfDay.substr(0, 1).toUpperCase()}
          // excludeDates={[(new Date('09/11/2022')), (new Date('10/11/2022'))]}
          // includeDateIntervals={[
          //   { start: date.subtract(new Date(), 5), end: date.addDays(new Date(), 5) },
          // ]}
          excludeDates={[new Date("2022-11-08")]}
          locale="es"
          dateFormat="yyyy 'MM' dd'.'"
          month= "short"
          {...datepickerProps}
        />
      </div>
    </>
  );
};

export default GenericCalendar;

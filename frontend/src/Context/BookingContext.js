import React, { useContext, useState } from "react";

const BookingContext = React.createContext();

const LOCAL_STORAGE_BOOKING = "booking.digital.house";
const LOCAL_STORAGE_USER = "currentUser";

// PROVIDERS
export const BookingContextProvider = ({ children }) => {
  const initialValue = {
    booking: {},
  };
  let bookingItem = JSON.parse(localStorage.getItem(LOCAL_STORAGE_BOOKING));
  let userItem = JSON.parse(localStorage.getItem(LOCAL_STORAGE_USER));

  const [booking, setBooking] = useState(bookingItem || initialValue);
  const [user, setUser] = useState(userItem || {});

  const updateBooking = (bookingData) => {
    setBooking((previous) => {
      const data = {
        ...previous,
        ...bookingData,
      };
      localStorage.setItem(LOCAL_STORAGE_BOOKING, JSON.stringify(data));
      return data;
    });
  };

  const updateUser = (userData) => {
    setUser((previous) => {
      const data = {
        ...previous,
        ...userData,
      };
      localStorage.setItem(LOCAL_STORAGE_USER, JSON.stringify(data));
      return data;
    });
  };

  const value = {
    user,
    booking,
    updateUser,
    updateBooking,
  };
  return (
    <BookingContext.Provider value={value}>{children}</BookingContext.Provider>
  );
};

export const useBookingContext = () => useContext(BookingContext);

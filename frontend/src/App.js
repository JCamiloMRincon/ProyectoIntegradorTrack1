import './App.scss';
import { Route, Routes } from 'react-router-dom';
import ComponenteDePrueba from './Components/ComponenteDePrueba';
import Home from './Components/Home';
import Login from './Components/Auth/Login/Login';
import Register from './Components/Auth/Register/Register';
import ProductDetail from "./Components/ProductDetail/ProductDetail";
import React, { useEffect, useState } from 'react';
import { BookingContextProvider } from './Context/BookingContext';
import Booking from './Components/Booking/Booking';
import AdminPage from './Components/AdminPage/AdminPage';
import ErrorPage from './Components/Error/ErrorPage';

function App() {
  const [logueado,setLog] = useState(false);

  

  return (
    
    <div className='App'>
      <BookingContextProvider>
        <Routes>
        <Route path='/' element={<Home log={logueado}/>}>
          </Route>
          <Route path='/home' element={<Home log={logueado}/>}>
          </Route>
          <Route path="/detalle" element={<ProductDetail />}></Route>
          <Route path='/reserva' element={<Booking/>}>
          </Route>
          <Route path='/register' element={<Register/>}>
          </Route>
          <Route path='/login' element={<Login/>}>
          </Route>
          <Route path='/admin' element={<AdminPage/>}>
          </Route>
          <Route path='*' element={<ErrorPage/>}/>
        </Routes> 
      </BookingContextProvider>
    </div>
  );
}

export default App;

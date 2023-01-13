import React from 'react'
import Input from '../Commons/Input/Input'
import './DataBooking.scss'

const DataBooking = () => {
  return (
    <div className="dataBooking">
      <h1>Completá tus datos</h1>
      <div className="container">
          <form className='data'>
          <Input 
           label="Nombre" type="text" 
           required={true}
           />
           <Input 
           label="Apellido" type="text" 
           required={true}
           />
           <Input 
           label="Correo electrónico" type="email" 
           required={true}
           />
          </form>
        </div>
    </div>
  )
}

export default DataBooking
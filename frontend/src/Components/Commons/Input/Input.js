import React from 'react'
import './Input.scss'

const Input = ({label, error, ...props}) => {


  return (
      <div className='input-component'>
        <label>{label}</label>
        <input className='input-custom' {...props}/>
        {error && <div className='error'>{error}</div>}
      </div>
      )
}

export default Input
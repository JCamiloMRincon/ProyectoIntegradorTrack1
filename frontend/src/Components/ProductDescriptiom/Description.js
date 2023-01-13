import React from 'react'
import './Drescription.scss'

const Description = ({descripcion,subTitle}) => {
  console.log(descripcion)
  console.log(subTitle)
  return (
    <div className='descriptionContainer'>
        <h3>{subTitle}</h3>
        <p>
       {descripcion}
        </p>
    </div>
  )
}

export default Description
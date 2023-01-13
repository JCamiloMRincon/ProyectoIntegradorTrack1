import React from 'react'
import copyRight from '../../Assets/copyRight.svg';
import ListIconsSocialNetworks from './ListIconsSocialNetworks';

const Footer = () => {
  return (
    <div  className="footer">
      <div>
      <b style={{color: "white"}}>©2022 Digital Booking</b>
      </div>
      <ListIconsSocialNetworks className="socialMediaIcons"/>
    </div>
  )
}

export default Footer
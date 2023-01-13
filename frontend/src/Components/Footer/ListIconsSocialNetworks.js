import React from 'react'
import { useEffect,useState } from 'react'
import IconTwitter from '../../Assets/iconTwitter.svg';
import IconFace from '../../Assets/iconFacebook.svg';
import IconIg from '../../Assets/iconIstragram.svg';
import IconLinkedin from '../../Assets/iconLinkedin.svg';


const ListIconsSocialNetworks = () => {
    const [icons, setIcons] = useState([IconFace,IconLinkedin,IconTwitter,IconIg]);

  return (
    <ul>
        {icons.map((icon, index) => 
        <li key={index}>
            <img src={icon} alt="icon"/>
        </li>)}
    </ul>
  )
}

export default ListIconsSocialNetworks
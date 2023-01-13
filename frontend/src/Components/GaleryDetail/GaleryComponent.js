import React from 'react'
import './GaleryComponent.scss'
import iconLikeIt from '../../Assets/iconLikeIt.svg';
import { useState, useEffect } from "react";
import share from '../../Assets/share.svg';
import Carousel from 'react-gallery-carousel';
import 'react-gallery-carousel/dist/index.css';

const GaleryComponent = ({imagesProduct}) => {

  console.log(imagesProduct)
  const [viewGalery, setViewGalery] = useState(false);
  // const images = [13, 8, 7, 6, 5].map((number) => ({
  //   src: `https://placedog.net/${number}00/${number}00?id=${number}`
  // }));

  const [isLoading, setIsLoading] = useState([]);
  const images = imagesProduct.map((image) => ({
    src: image.url
  }));

  const view = (e) => {
    e.preventDefault()
    setViewGalery(true)

  }

  return (
    <>
    <div className='galeryAction'>
    <img src={share} alt="Menu" />
    <img src={iconLikeIt} alt="Menu" />
    </div>
    <div className='GaleryComponent'>
        <div className='mainImage'>
          <figure>
            <img className='two' src={imagesProduct[0]?.url ||'https://i.pinimg.com/474x/bd/10/ba/bd10ba5bdbe609b1bb51dafc3a078834.jpg'}  width="100%" height={500} alt=""></img>
                <figcaption>
                  1/5            
                </figcaption> 
            </figure>
        </div>
        <div className='images'>
           <figure>
            <img className='two' src={imagesProduct[1]?.url ||'https://i.pinimg.com/474x/bd/10/ba/bd10ba5bdbe609b1bb51dafc3a078834.jpg'}  width="95%" height={240} alt=""></img>
                <figcaption>            
                </figcaption> 
            </figure>
            <figure>
            <img className='two' src={imagesProduct[2]?.url ||'https://i.pinimg.com/474x/bd/10/ba/bd10ba5bdbe609b1bb51dafc3a078834.jpg'}  width="95%" height={240} alt=""></img>
                <figcaption>            
                </figcaption> 
            </figure>
        </div>
        <div className='images'>
            <figure>
            <img className='two' src={imagesProduct[3]?.url ||'https://i.pinimg.com/474x/bd/10/ba/bd10ba5bdbe609b1bb51dafc3a078834.jpg'}  width="95%" height={240} alt=""></img>
                <figcaption>            
                </figcaption> 
            </figure>
            <figure className='imageLink'>
            <img className='two' src={imagesProduct[4]?.url ||'https://i.pinimg.com/474x/bd/10/ba/bd10ba5bdbe605b1bb51dafc3a078834.jpg'}  width="95%" height={240} alt=""></img>
                <figcaption >    
                  <a href='#' onClick={view}> ver mas</a>       
                </figcaption> 
            </figure>
        </div>
        {
          viewGalery ? 
          <div className='galery'>

          <a href="/detalle"><b>Cerrar</b></a>
          <Carousel images={images} style={{ height: 500, width: 800}} hasSizeButton='false'/>       
          </div>  : 
          <></>
        }
         
              
    </div>
    </>
    
  )
}

export default GaleryComponent
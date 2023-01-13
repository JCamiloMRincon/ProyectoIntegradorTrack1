import React from "react";
import { useState, useEffect } from "react";
import Header from "../Header/Header";
import DetailHeader from "../DetailHeader/DetailHeader";
import Body from "../Body/Body";
import Footer from "../Footer/Footer";
import DetailAddress from "../DetailAddress/DetailAddress";
import Carousel from 'react-gallery-carousel';
import 'react-gallery-carousel/dist/index.css';
import GaleryComponent from "../GaleryDetail/GaleryComponent";
import Description from "../ProductDescriptiom/Description";
import FeaturesBlock from "../ProductPage/FeaturesBlock/FeaturesBlock";
import ReservationsBlock from "../ProductPage/ReservationsBlock/ReservationsBlock";
import PoliciesBlock from "../ProductPage/PoliciesBlock/PoliciesBlock";
import { renderMatches } from "react-router-dom";

const ProductDetail = () => {

  const urlBase = 'http://18.116.203.145:8085/'
  const getProducto = urlBase + 'productos/'

  
  const [isLoading, setIsLoading] = useState(true);
  const [productoInfo,setProductoInfo] = useState({});
  const [productoUbicacion,setProductoUbicacion] = useState('');
  const [productoUbicacionPais,setProductoUbicacionPais] = useState('');
  const [productocaracteristicas,setProductoCaracteristicas] = useState([]);
  const [productoImages,setProductoImages] = useState([]);
  const [productoInfoCategory,setProductoInfoCategory] = useState('');
  const [productoInfoCategoryDes,setProductoInfoCategoryDes] = useState('');

  useEffect(() => {
    let id = JSON.parse(localStorage.getItem('selectedProduct'));
    fetch(getProducto+id)
    .then((response) => response.json())
    .then((producto) => {
      console.log(producto)
          setProductoInfo(producto)
          setProductoInfoCategory(producto.categoria.titulo)
          setProductoInfoCategoryDes(producto.categoria.descripcion)
          setProductoImages(producto.imagenes)
          setProductoUbicacion(producto.ciudad.nombre)
          setProductoUbicacionPais(producto.ciudad.pais.nombre)
          setProductoImages(producto.imagenes)
          setProductoCaracteristicas(producto.caracteristicas)
    })
    .catch(function(error) {
        console.log("error")
    });
    
  }, []);

  return (
    <div>
     
      <Header className="header" />
      <DetailHeader title={productoInfo.titulo || ''} category={productoInfoCategory || ''}/>
      <DetailAddress direccion={productoInfo.direccion || ''} ciudad={productoUbicacion || ''} pais={productoUbicacionPais || ''} />
      <Body className="body">
      <GaleryComponent imagesProduct={productoImages || ''}></GaleryComponent>
      <Description descripcion={productoInfo.descripcion || ''} subTitle={productoInfoCategoryDes|| ''}></Description>
       <FeaturesBlock caracteristicas={productocaracteristicas || ''}></FeaturesBlock>
      <ReservationsBlock></ReservationsBlock>
      <PoliciesBlock ></PoliciesBlock>
      </Body>
      <Footer className="footer"></Footer>
    </div>
  );
};

export default ProductDetail;

import React from "react";
import { useEffect } from "react";
import "./ListCard.scss";

const ListCard = (props) => {

  const { products } = props;

  useEffect(() => {   
    console.log(products.length); 
  }, [products]);

  const viewDetail = (e) => {
    e.preventDefault();
    document.location.href = "/detalle";
    localStorage.setItem('selectedProduct', e.target.value);
  }
  
  return (
    <>
      {products.map((department) => (
        <li key={department.id}>
          <div className="list-card">
            <div className="list-card-image">
              <img src={department.imagenes[0].url} alt={department.titulo}></img>
            </div>
            <div className="list-card-info">
              <div className="list-card-title">
                <div className="list-card-title__text">
                  <h4>{department.categoria.titulo.toUpperCase()}</h4>
                  <h1>{department.titulo}</h1>
                </div>
                <div className="list-card-title__rating">
                  {/* <h2>8</h2> */}
                  {/* <h4>Muy bueno</h4> */}
                </div>
              </div>
              <p>{department.ciudad.nombre}</p>
              <p>{department.descripcion}</p>
              <button className="button-two" onClick={viewDetail} value={department.id}>Ver detalle</button>
            </div>
          </div>
        </li>
      ))}
    </>
  );
};

export default ListCard;

import React from "react";
import "./DetailAddress.scss";
import IconLocation from "../../Assets/iconLocation.svg";
import DetailCalification from "../DetailCalification/DetailCalification";

const DetailAddress = ({direccion,ciudad,pais}) => {
  console.log(direccion)
  console.log(ciudad)
  console.log(pais)
  return (
    <div className="container-address">
      <div className="address">
        <div className="info-address">
          <span>
            <img src={IconLocation} alt="location" width="30px" />
            {ciudad}, {pais} <br />
            {direccion}
          </span>
          <DetailCalification></DetailCalification>
        </div>
      </div>
    </div>
  );
};

export default DetailAddress;

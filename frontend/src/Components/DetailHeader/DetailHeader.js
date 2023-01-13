import React from "react";
import { Link } from "react-router-dom";
import IconArrowBack from "../../Assets/iconArrowBack.svg";
import "./DetailHeader.scss";

const DetailHeader = ({title,category}) => {
  console.log(title)
  console.log(category)

  return (
    <div className="container-header">
      <div className="deparments">
        <div className="tittle-deparments">
          <span>{category || '' }</span>
          <div>
            <h3>{title || ''}</h3>
          </div>
        </div>

        <div className="arrow">
          <Link to='/home'>
            <img src={IconArrowBack} alt="arrow" />
          </Link>
        </div>
      </div>
    </div>
  );
};

export default DetailHeader;

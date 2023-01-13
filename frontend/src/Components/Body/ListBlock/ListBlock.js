import React from "react";
import { useEffect } from "react";
import ListCard from "./ListCard/ListCard";
import "./ListBlock.scss";

const ListBlock = (props) => {

  const { products } = props;

  useEffect(() => {
  }, [products]);

  return (
    <div className="list-block">
      <div className="list-title">
        <h1>Recomendaciones</h1>
      </div>
      <div>
        <ul className="list-container">
          <ListCard products={products}></ListCard>
        </ul>
      </div>
    </div>
  );
};

export default ListBlock;

import React from "react";
import CategoryCard from "./CategoryCard/CategoryCard";
import "./CategoriesBlock.scss";

const CategoriesBlock = (props) => {

  const { onSelectCategory } = props
  return (
    <div className="categories-block">
      <div className="categories-title">
        <h1>Categorías</h1>
        <p>Selecciona el tipo de alojamiento que se adapte a tu necesidad</p>
      </div>
      <div>
        <ul className="categories-container">
          <CategoryCard onSelectCategory={onSelectCategory}></CategoryCard>
        </ul>
      </div>
    </div>  
  );
};

export default CategoriesBlock;

import React , { useState, useEffect
} from "react";
import axios from "axios";
import categories from "../../../../json/categories.json";
import "./CategoryCard.scss";

const CategoryCard = (props) => {

  const [categories, setCategories] = useState([]);

  const baseUrl = 'http://18.116.203.145:8085';

  function random_sort(a, b) {
    return Math.random() - 0.5;
   }

  useEffect(() => {    
    axios.get(baseUrl + '/categorias')
    .then((response) => {
      setCategories(response.data);
      // console.log(response.data.sort(random_sort));
    })
    .catch(function (error) {
      console.log(error);
    });
  },[]);

  const handleClick = (e) => {
    if(e.target.parentNode.parentNode.className === "category-card") {
      var category = e.target.parentNode.parentNode.getAttribute("category")
      props.onSelectCategory(category);
    }
    // console.log(e.target.parentNode.parentNode.getAttribute("category"))
  }
  
  return (
    <>
      {categories.map((category) => (
        <li key={category.id} onClick={handleClick}>
          <div className="category-card" category={category.id}>
            <div className="category-card-image">
              <img src={category.urlimagen} alt={category.titulo}></img>
            </div>
            <div className="category-card-caption">
              <h2>{category.titulo}</h2>
              <h4>{category.descripcion}</h4>
            </div>
          </div>
        </li>
      ))}
    </>
  );
};

export default CategoryCard;

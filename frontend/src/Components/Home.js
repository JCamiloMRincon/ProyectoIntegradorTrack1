import { useState, useEffect } from "react";
import axios from "axios";
import Swal from 'sweetalert2'
import withReactContent from 'sweetalert2-react-content'
import Footer from './Footer/Footer'
import Header from './Header/Header'
import '../App.scss'
import Body from './Body/Body'
import CategoriesBlock from './Body/CategoriesBlock/CategoriesBlock'
import ListBlock from './Body/ListBlock/ListBlock'
import ComponenteDePrueba from './ComponenteDePrueba'
import Searcher from './Searcher/Searcher'

const Home = () => {

  const baseUrl = 'http://18.116.203.145:8085';

  const [productos , setProductos] = useState([]);
  
  const MySwal = withReactContent(Swal);
  const alertNoProducts = () => {
    MySwal.fire({
      title: "¡Oops!",
      text: "Lo sentimos, no hay disponibilidad para tu selección",
      icon: "error",
      button: "Aceptar"
    })
  }

  const onSelectCity = (city) => {
    axios.get(baseUrl + '/productos/ciudad/' + city)
    .then((response) => {
      setProductos(response.data);
      if (response.data.length <= 0) {
        alertNoProducts()
      };
    })
    .catch(function (error) {
      console.log(error);
    });
  }

  const onSelectCategory = (category) => {
    axios.get(baseUrl + '/productos/categoria/' + category)
    .then((response) => {
      setProductos(response.data);
      if (response.data.length <= 0) {
        alertNoProducts()
      };
    })
    .catch(function (error) {
      console.log(error);
    });
  }

  function random_sort(a, b) {
    return Math.random() - 0.5;
   }

  useEffect(() => {    
    axios.get(baseUrl + '/productos')
    .then((response) => {
      setProductos(response.data.sort(random_sort));
    })
    .catch(function (error) {
      console.log(error);
    });
  },[]);

  return (
    <div>
        <Header className="header"></Header>
        <Searcher onSelectCity={onSelectCity}></Searcher>
        <Body className="body">
          <CategoriesBlock onSelectCategory={onSelectCategory}></CategoriesBlock>
          <ListBlock products={productos}></ListBlock>
        </Body>
        <Footer className="footer"></Footer>
    </div>
  )
}

export default Home;
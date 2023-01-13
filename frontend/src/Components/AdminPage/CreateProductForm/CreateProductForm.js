import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

import "./CreateProductForm.scss";

const CreateProductForm = () => {
  const baseUrl = "http://18.116.203.145:8085";

  const [optionCities, setOptionCities] = useState([]);
  const [optionCategories, setOptionCategories] = useState([]);
  const [optionFeatures, setOptionFeatures] = useState([]);
  const [optionPolicies, setOptionPolicies] = useState([]);

  const [features, setFeatures] = useState([]);
  const [image, setImage] = useState("");
  const [images, setImages] = useState([]);
  const [policies, setPolicies] = useState([]);

  const [product, setProduct] = useState({
    titulo: null,
    categoriaId: null,
    direccion: null,
    ciudadId: null,
    descripcion: null
  });

  const MySwal = withReactContent(Swal);
  const alertError = () => {
    MySwal.fire({
      title: "¡Oops!",
      text: "Lo sentimos, no pudimos crear el producto",
      icon: "error",
      button: "Aceptar"
    })
    .then(() => {
      // Aquí la alerta se ha cerrado
      console.log("Alerta cerrada");
  });
  }

  const alertSuccess = () => {
    MySwal.fire({
      title: "¡Yeih!",
      text: "El producto fue creado exitosamente",
      icon: "success",
      button: "Aceptar"
    })
    .then(() => {
      emptyForm();
      setFeatures([]);
      setImage("");
      setImages([]);
      setPolicies([]);
      setProduct([]);
      // Aquí la alerta se ha cerrado
      console.log("Alerta cerrada");
  });
  }

  const emptyForm = () => {
    document.getElementById("product-form").reset();
  }

  useEffect(() => {
    handleFetchPolicies();
    handleFetchFeatures();
  },[]);

  const handleFetchPolicies = () => {
    axios
      .get(baseUrl + "/politicas")
      .then((response) => {
        setOptionPolicies(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  const handleFetchFeatures = () => {
    axios
      .get(baseUrl + "/caracteristicas")
      .then((response) => {
        setOptionFeatures(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  const handleFetchCategories = () => {
    axios
    .get(baseUrl + "/categorias")
    .then((response) => {
      setOptionCategories(response.data);
    })
    .catch(function (error) {
      console.log(error);
    });
  }

  const handleFetchCities = () => {
    axios
      .get(baseUrl + "/ciudades")
      .then((response) => {
        setOptionCities(response.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  const handlePropertyName = (e) => {
    var propertyName = e.target.value;
    setProduct({ ...product, titulo: propertyName });
  };

  const handleSelectCategory = (e) => {
    var categoryId = e.target.value;
    setProduct({ ...product, categoriaId: categoryId });
  };

  const handleAddress = (e) => {
    var address = e.target.value;
    setProduct({ ...product, direccion: address });
  };

  const handleSelectCity = (e) => {
    var city = e.target.value;
    setProduct({ ...product, ciudadId: city });
  };

  const handleSelectFeature = (event) => {
    var featureId = event.target.value;
    setFeatures([...features, {id: featureId}]);
  };

  const handleDescription = (e) => {
    var description = e.target.value;
    setProduct({ ...product, descripcion: description });
  };

  const handleSelectPolicy = (e) => {
    var policyId = e.target.value;
    setPolicies([...policies, {id: policyId}]);
  };

  const handleImageUrl = (e) => {
    var imageUrl = e.target.value;
    setImage(imageUrl);
  };

  const handleAddImage = (e) => {
    //var imageUrl = e.target.value;
    setImages([...images, {url: image}]);
  }

  const handleSubmit = (e) => {
    console.log("Se envió el formulario: " + JSON.stringify(product));
    e.preventDefault();
    const productData = {
      titulo: product.titulo,
      categoriaId: product.categoriaId,
      direccion: product.direccion,
      ciudadId: product.ciudadId,
      descripcion: product.descripcion,
      disponible: true,
      imagenes: images,
      caracteristicas: features,
      politicas: policies
    };
    console.log(productData);

    var currentUser = JSON.parse(localStorage.currentUser);
    var token = currentUser.token;
    const config = {
      headers: { Authorization: `Bearer ${token}` }
  };
  
    axios
      .post(baseUrl+ "/productos", productData, config)
      .then((response) => {
        console.log(response.status);
        console.log(response.data);
        alertSuccess();
      })
      .catch(function (error) {
        console.log(error);
        alertError();
      });
  };

  return (
    <div className="createProductForm">
      <h1>Crear propiedad</h1>
      <form onSubmit={handleSubmit} className="form" id="product-form">
        <div className="form-firstContainer">
          <label>
            Nombre de la propiedad
            <input
              required={true}
              type="text"
              name="propertyName"
              placeholder="Escribe aquí"
              onChange={handlePropertyName}
              className="form-firstContainer__input"
            />
          </label>
          <label>
            Categoría
            <select
            required={true}
              onChange={handleSelectCategory}
              onClick={handleFetchCategories}
              placeholder="Categoría"
              className="form-firstContainer__input"
            >
              <option value="" disabled selected hidden>
                Categoría
              </option>
              {optionCategories.map((category) => (
                <option key={category.id} value={category.id}>
                  {category.titulo}
                </option>
              ))}
            </select>
          </label>
          <label>
            Dirección
            <input
            required={true}
              type="text"
              name="address"
              placeholder="Escribe aquí"
              onChange={handleAddress}
              className="form-firstContainer__input"
            />
          </label>
          <label>
            Ciudad
            <select
            required={true}
              onChange={handleSelectCity}
              onClick={handleFetchCities}
              placeholder="Ciudad"
              className="form-firstContainer__input"
            >
              <option value="" disabled selected hidden>
                Ciudad
              </option>
              {optionCities.map((city) => (
                <option key={city.id} value={city.id}>
                  {city.nombre}
                </option>
              ))}
            </select>
          </label>
          <label className="textarea-label">
            Descripción:
            <textarea
            required={true}
              placeholder="Escribe aquí"
              onChange={handleDescription}
              className="form-firstContainer__textarea"
            />
          </label>
        </div>
        <div>
          <h1>Caracteristicas</h1>
          <div className="form-secondContainer">
            {
              optionFeatures.map((feature) => {
                return <label><input type="checkbox" key={feature.id} value={feature.id} onChange={handleSelectFeature}/>{feature.nombre}</label>
              }) 
            }
          </div>
        </div>
        <div>
          <h1>Políticas del producto</h1>
          <div className="form-thirdContainer">
            {
              optionPolicies.map((policy) => {
                return <label><input type="checkbox" key={policy.id} value={policy.id} onChange={handleSelectPolicy}/>{policy.nombre}</label>
              }) 
            }
          </div>
        </div>
        <div>
          <h1>Cargar imágenes</h1>
          <div className="form-fourthContainer">
            <label>
              Url
              <input
              required={true} 
                type="text"
                name="url"
                placeholder="Insertar https://"
                className="form-fourthContainer__input"
                onChange={handleImageUrl}
              />
            </label>
            <button type="button" className="form-fourthContainer__button" onClick={handleAddImage}>+</button>
          </div>
          <div className="form-fourthContainerList">
            {images.map((image, i) => (
              <label>
              <input
                key={i}
                type="text"
                name="url"
                disabled
                value={(image.url)}
                className="form-fourthContainer__input"
              />
            </label>
            ) )}
          </div>
        </div>
        <input type="submit" value="Crear" className="button-one submit-button"/>
      </form>
    </div>
  );
};

export default CreateProductForm;

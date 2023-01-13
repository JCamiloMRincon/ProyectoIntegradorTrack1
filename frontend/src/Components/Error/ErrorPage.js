import React from "react";
import Header from "../Header/Header";
import Footer from "../Footer/Footer";
import Body from "../Body/Body";
import "./ErrorPage.scss";

const ErrorPage = () => {
  return (
    <>
      <Header className="header"></Header>
      <div className="errorBody">
        <h1 className="status">404</h1>
        <h1 className="title">La página que buscas no existe</h1>
        <a href="/home" className="url">Regresar</a>
      </div>
      <Footer className="footer"></Footer>
    </>
  );
};

export default ErrorPage;

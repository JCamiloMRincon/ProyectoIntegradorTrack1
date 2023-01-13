import { useState, useEffect } from "react";
import Header from "../Header/Header";
import Footer from "../Footer/Footer";
import ErrorPage from "../Error/ErrorPage";
import CreateProductForm from "./CreateProductForm/CreateProductForm";

const AdminPage = () => {

    const [isAdmin, setIsAdmin] = useState(false)

    useEffect(() => {
        const user = JSON.parse(localStorage.getItem('currentUser'));
        if (user.firstName === "Camilo") {
            setIsAdmin(true)
        }else{
          console.log("No hay sesión iniciada")
        }
      }, []);

    var currentUser = JSON.parse(localStorage.currentUser);

    return (
        <div>
            <Header className="header"></Header>
            {isAdmin ? (
        <CreateProductForm></CreateProductForm>
      ) : (
        <ErrorPage></ErrorPage>
      )}
            
            <Footer className="footer"></Footer>
        </div>
      )
}

export default AdminPage;
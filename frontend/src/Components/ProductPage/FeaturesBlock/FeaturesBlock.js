import React from "react";
import Feature from "./Feature/Feature";
import './FeaturesBlock.scss'

const FeaturesBlock = ({caracteristicas}) => {
    console.log(caracteristicas)
    return (
        <div className="features-block">
            <h1 className="title">¿Qué ofrece este lugar?</h1>
            <hr />
            <ul className="features-list">
                <Feature caracteristicas={caracteristicas}></Feature>
            </ul>
        </div>
    );
};

export default FeaturesBlock;
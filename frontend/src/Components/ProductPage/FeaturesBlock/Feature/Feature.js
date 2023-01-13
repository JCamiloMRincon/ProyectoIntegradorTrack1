import React from "react";
import './Feature.scss'

const Feature = ({caracteristicas}) => {
    // const [icons, setIcons] = useState(icon);
    console.log(caracteristicas)
    return(
        <>
        {caracteristicas.map((feature) => (
            <li className="feature-item" key={feature.id}>
                <img className="feature-icon" src={feature.urlicono} alt="icon"></img>
                <p className="feature-name">{feature.nombre}</p>
            </li>
        ))}
        </>
    );
};

export default Feature;
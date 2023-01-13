import React from "react";
import "./PolicyItem.scss";

const PolicyItem = (props) => {
    return (
        <>
        {props.policyItems.map((item) => (
            <li className="policy-item" key={item.id}>
                <p>{item.description}</p>
            </li>
        ))}
        </>
    )
};

export default PolicyItem;
import React from "react";
import policies from "../../../json/policies.json";
import PolicyItem from "./Policy/PolicyItem";
import "./PoliciesBlock.scss"

const PoliciesBlock = () => {
    return (
        <div className="policies-block">
            <h1 className="title">Qué tenés que saber</h1>
            <hr />
            <ul className="policies-block__list">
                {policies.map((policy) => (
                    <li key={policy.id}>
                        <h2 className="policies-block__list-title">{policy.name}</h2>
                        <ul>
                            <PolicyItem policyItems={policy.policies}></PolicyItem>
                        </ul>
                    </li>
                ))}
            </ul>

        </div>
    );
};

export default PoliciesBlock;
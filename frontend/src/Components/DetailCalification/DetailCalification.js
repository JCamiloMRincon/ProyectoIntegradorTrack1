import React from "react";
import IconStar from "../../Assets/iconStar.svg";
import IconStarFull from "../../Assets/iconStarFull.svg";

const DetailCalification = ({ calification = 5 }) => {
  const ranking = [0, 1, 2, 3, 4];
  return (
    <div>
      <span>
        Muy bueno <br />
        {ranking.map((item) => (
          <img
            src={item <= calification ? IconStarFull : IconStar}
            alt="star"
            width="30px"
          />
        ))}
      </span>
    </div>
  );
};

export default DetailCalification;

import React from "react";
import "./Styles/Footer.css";

const Footer = () => {
  return (
    <>
      <div id="footer">
        <div className="newsletter">
          Sign up for our News letter to keep <br />
          up-to-date with the latest trends in the market. <br />
          {/* Add SendGrID API Here */}
          <input type="email" placeholder="Sign up using your email here" />
          <button class="button-54">Submit</button>
          {/* <button id="newsbutton">Submit</button> */}
        </div>
      </div>
    </>
  );
};

export default Footer;

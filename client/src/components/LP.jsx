import React from "react";
import "./Styles/LP.css";
import "./Styles/Button.css";
import "./Styles/Button2.css";
import { Link } from "react-router-dom";
import Navbar from "./Navbar";
import Footer from "./Footer";

const LP = () => {
  return (
    <>
      {/* PAGE 1 */}
      <div id="parentdiv">
        <Navbar />

        <div id="herosection">
          <h1>Analyze Your</h1>
          <br />

          <h2 id="h2Invest">Investments</h2>
          <br />

          <h5>
            "Track your stock portfolio in real-time with our sleek and
            intuitive market tracker."
          </h5>
          <br />

          <Link to="/advisor" className="LinkButton">
            <button class="button-86">Click here</button>
          </Link>
        </div>
      </div>

      {/* Page 4 */}
      <Footer />
    </>
  );
};

export default LP;

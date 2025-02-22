import React, { useState, useEffect } from "react";
import Navbar from "../Navbar";
import "../Styles/Dashboard.css";

const Dashboard = () => {
  const [nos, setNos] = useState("");
  const [category, setCategory] = useState("");
  const [cmp, setCmp] = useState("");
  const [total, setTotal] = useState("");
  const [searchTerm, setSearchTerm] = useState("");
  const [searchResults, setSearchResults] = useState([]);
  const stock_key = process.env.REACT_APP_API_KEY_Stock;

  // Debounce Search API Calls
  useEffect(() => {
    if (searchTerm) {
      const delay = setTimeout(() => fetchSearchResults(searchTerm), 500);
      return () => clearTimeout(delay);
    } else {
      setSearchResults([]); // Clear results when input is empty
    }
  }, [searchTerm]);

  const handleSearch = (e) => setSearchTerm(e.target.value);

  const fetchSearchResults = (term) => {
    const searchURL = `https://financialmodelingprep.com/api/v3/search?exchangeShortName=NSE&query=${term}&apikey=${stock_key}`;
    fetch(searchURL)
      .then((response) => response.json())
      .then((data) => setSearchResults(data))
      .catch((err) => console.error("Error fetching stocks:", err));
  };

  const handleSelect = (result) => {
    setCategory(result.exchangeShortName || "N/A");
    setSearchTerm(result.name); // Set input field to selected stock
    setSearchResults([]); // Hide dropdown
  };

  return (
    <>
      <Navbar />
      <div id="dash-main">
        <div id="dash-right">
          <h1 id="ys-h1">Your Stocks</h1>
          <h6>Here are the stocks you are currently tracking</h6>
          <div className="add-div">
            {/* Stock Search */}
            <span>
              <i className="fa-solid fa-magnifying-glass" id="icon-hover"></i>
              <input
                id="i1"
                type="text"
                placeholder="Select your Stock"
                value={searchTerm}
                onChange={handleSearch}
              />
              {searchResults.length > 0 && (
                <ul className="dropdown">
                  {searchResults.map((result) => (
                    <li
                      key={result.symbol}
                      onClick={() => handleSelect(result)}
                    >
                      {result.name}
                    </li>
                  ))}
                </ul>
              )}
            </span>

            {/* Number of Stocks */}
            <span>
              <i className="fa-solid fa-hashtag" id="icon-hover"></i>
              <input
                id="i2"
                type="number"
                placeholder="No. of Stocks"
                value={nos}
                onChange={(e) => setNos(e.target.value)}
              />
            </span>

            {/* Category */}
            <span>
              <i className="fa-solid fa-list" id="icon-hover"></i>
              <input
                id="i3"
                type="text"
                placeholder="Category"
                value={category}
                onChange={(e) => setCategory(e.target.value.toUpperCase())}
              />
            </span>

            {/* Current Market Price */}
            <span>
              <i className="fa-solid fa-indian-rupee-sign" id="icon-hover"></i>
              <input
                id="i4"
                type="number"
                placeholder="Current Market Price"
                value={cmp}
                onChange={(e) => setCmp(e.target.value)}
              />
            </span>

            {/* Total Invested */}
            <span>
              <i className="fa-solid fa-money-bill" id="icon-hover"></i>
              <input
                id="i5"
                type="number"
                placeholder="Total Invested"
                value={total}
                onChange={(e) => setTotal(e.target.value)}
              />
            </span>

            <button id="addbtn">Add</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Dashboard;

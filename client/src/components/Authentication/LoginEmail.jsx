import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // ✅ Import useNavigate
import axios from "axios";
import Form from "react-bootstrap/Form";
import "./Styles/Login.css";

const LoginEmail = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate(); // ✅ Initialize navigate

  const handleLogin = (e) => {
    e.preventDefault();

    axios
      .post(
        `http://localhost:8080/advisor/login-via-email?email=${email}&password=${password}`
      )
      .then(() => {
        alert("User Logged in Successfully");
        navigate("/dashboard"); // ✅ Redirect to Dashboard on success
      })
      .catch((err) => {
        console.error(err);
        alert("Wrong Credentials entered");
      });
  };

  return (
    <>
      <div id="box-parent">
        <div id="box-child">
          <Form id="form">
            <label>Email address</label>
            <input
              type="email"
              placeholder="Enter email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <br />

            <label>Password</label>
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <br />

            <label id="checkbox">
              <input type="checkbox" /> Keep me logged in{" "}
            </label>

            <button type="submit" id="loginbutton" onClick={handleLogin}>
              Log in
            </button>
          </Form>
        </div>
      </div>
    </>
  );
};

export default LoginEmail;

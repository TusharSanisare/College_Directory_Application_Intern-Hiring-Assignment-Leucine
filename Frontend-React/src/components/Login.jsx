import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/login",
        {
          username,
          password,
        }
      );

      const { token, role, userId } = response.data;
      console.log(response.data);

      // Store the token and role
      localStorage.setItem("token", token);
      localStorage.setItem("role", role);
      localStorage.setItem("userId", userId);

      // Redirect based on role
      if (role === "ROLE_STUDENT") {
        navigate(`/student-profile`);
        console.log("student-profile");
      } else if (role === "ROLE_FACULTY") {
        // window.location.href = "/faculty-dashboard";
        console.log("faculty-dashboard");
      } else if (role === "ROLE_ADMIN") {
        // window.location.href = "/admin-dashboard";
        console.log("admin-dashboard");
      }
    } catch (err) {
      // console.log(err);
      setError("Invalid username or password");
    }
  };

  return (
    <div>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Login</button>
        {error && <p>{error}</p>}
      </form>
    </div>
  );
};

export default Login;

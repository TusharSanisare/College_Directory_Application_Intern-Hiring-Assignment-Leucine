import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Login from "./components/Login";
import Profile from "./components/Profile";
import StudentProfile from "./components/StudentProfile";

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/student-profile" element={<StudentProfile />} />
          {/* <Route path="/faculty-dashboard/:id" element={<FacultyDashboard />} />
          <Route path="/admin-dashboard/:id" element={<AdminDashboard />} /> */}
          {/* <Route path="/student-dashboard/:id" element={<StudentDashboard />} />
          <Route path="/faculty-dashboard/:id" element={<FacultyDashboard />} />
          <Route path="/admin-dashboard/:id" element={<AdminDashboard />} /> */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;

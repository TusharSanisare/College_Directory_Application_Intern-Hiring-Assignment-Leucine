import React, { useEffect, useState } from "react";
import axios from "axios";
import Logout from "./Logout";

const StudentProfile = () => {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        // Retrieve the token from localStorage or any other storage mechanism you're using
        const token = localStorage.getItem("token");
        const userId = localStorage.getItem("userId");

        // Set up the headers with the Authorization token
        const config = {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        };

        // Send GET request with the token in the Authorization header
        const response = await axios.get(
          `http://localhost:8080/api/students/${userId}`,
          // `http://localhost:8080/api/users/${userId}`,
          config
        );
        console.log(response.data);
        setProfile(response.data);
      } catch (error) {
        console.error("Error fetching profile:", error);
      }
    };

    fetchProfile();
  }, []);

  return (
    // <div>
    //   {profile ? (
    //     <>
    //       <p>id: {profile.id}</p>
    //       <p>username: {profile.username}</p>
    //       <p>password: {profile.password}</p>
    //       <p>role: {profile.role}</p>
    //       <p>email: {profile.email}</p>
    //       <p>phone: {profile.phone}</p>

    //       {/* "id": 1, "username": "s", "password":
    //       "$2a$10$TJqXabJP317hDdM9ieMTLe4UUwi4/yFgVpXzin4HNYWFcMVLmqCl6",
    //       "role": "ROLE_STUDENT", "name": "student", "email":
    //       "studenttest@gmail.com", "phone": "9867895472" */}
    //     </>
    //   ) : (
    //     <p>Loading...</p>
    //   )}
    // </div>

    <div>
      {profile ? (
        <div>
          <Logout />
          <p>
            <strong>User ID:</strong> {profile.userId}
          </p>
          <p>
            <strong>Department ID:</strong> {profile.departmentId}
          </p>
          <p>
            <strong>Year:</strong> {profile.year}
          </p>
          <img
            src={profile.photo}
            alt="Profile"
            style={{ width: "150px", height: "150px" }}
          />

          <h3>User Details:</h3>
          <p>
            <strong>Username:</strong> {profile.user.username}
          </p>
          <p>
            <strong>Name:</strong> {profile.user.name}
          </p>
          <p>
            <strong>Email:</strong> {profile.user.email}
          </p>
          <p>
            <strong>Phone:</strong> {profile.user.phone}
          </p>
          <p>
            <strong>Role:</strong> {profile.user.role}
          </p>

          {/* The password is sensitive, so avoid displaying it */}
          {/* <p>Password: {profile.user.password}</p> */}
        </div>
      ) : (
        <div>
          Loading... <br />
          <Logout />
        </div>
      )}
    </div>
  );
};

export default StudentProfile;

import React, { useEffect, useState } from "react";
import apiService from "../apiService";
import Logout from "./Logout";

const Profile = () => {
  const [profileData, setProfileData] = useState(null);

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await apiService.get("/user/profile", {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setProfileData(response.data);
      } catch (err) {
        console.error("Error fetching profile:", err);
      }
    };

    fetchProfile();
  }, []);

  if (!profileData) {
    return (
      <div>
        Loading profile... <br />
        <Logout />
      </div>
    );
  }

  return (
    <div>
      <h2>Profile</h2>
      <p>Username: {profileData.username}</p>
      <p>Email: {profileData.email}</p>
      <p>Role: {profileData.role}</p>
      <Logout />
    </div>
  );
};

export default Profile;

import axios from 'axios';

const API_URL = "http://localhost:8080/api"; // Replace with your actual backend URL

const apiService = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export default apiService;

import axios from 'axios';

const API_URL = 'http://localhost:8080';

export async function login(username, password) {
    const response = await axios.post(`${API_URL}/auth/login`, {
        username,
        password
    });

    return response.data;
}

export async function register(username, email, password) {
    const response = await axios.post(`${API_URL}/auth/register`, {
        username,
        email,
        password
    });

    return response.data;
}
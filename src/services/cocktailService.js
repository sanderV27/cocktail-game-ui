import axios from 'axios';

const API_URL = 'http://localhost:8080/api/cocktail';

export const getRandomCocktail = () => {
    return axios.get(`${API_URL}/random`);
};

export const makeGuess = (guess) => {
    return axios.post(`${API_URL}/guess`, { guess });
};

export const getHint = () => {
    return axios.get(`${API_URL}/hint`);
};

export const startNewGame = () => {
    return axios.post(`${API_URL}/new-game`);
};

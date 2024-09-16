package com.ridango.game;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CocktailService {

    private final java.lang.String API_URL = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    public Cocktail getRandomCocktail() {
        RestTemplate restTemplate = new RestTemplate();
        CocktailResponse response = restTemplate.getForObject(API_URL, CocktailResponse.class);
        return response.getDrinks().get(0);  // Get the first drink from the response
    }
}

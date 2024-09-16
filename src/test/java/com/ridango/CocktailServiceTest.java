package com.ridango;


import com.ridango.game.Cocktail;
import com.ridango.game.CocktailResponse;
import com.ridango.game.CocktailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CocktailServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CocktailService cocktailService;

    @Test
    void testGetRandomCocktail() {
        MockitoAnnotations.openMocks(this);

        // Set up mock response
        CocktailResponse mockResponse = new CocktailResponse();
        Cocktail mockCocktail = new Cocktail();
        mockCocktail.setStrDrink("Mojito");
        mockResponse.setDrinks(Arrays.asList(mockCocktail));

        when(restTemplate.getForObject("https://www.thecocktaildb.com/api/json/v1/1/random.php", CocktailResponse.class))
                .thenReturn(mockResponse);

        Cocktail result = cocktailService.getRandomCocktail();
        assertNotNull(result, "Cocktail should not be null.");
        assertEquals("Mojito", result.getStrDrink(), "The cocktail name should be 'Mojito'.");
    }
}

package com.ridango.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CocktailResponse {
    @JsonProperty("drinks")
    private List<Cocktail> drinks;

    // No-argument constructor
    public CocktailResponse() {
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks) {
        this.drinks = drinks;
    }
}

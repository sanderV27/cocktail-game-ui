package com.ridango.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Cocktail {
        @JsonProperty("idDrink")
        private String idDrink;

        @JsonProperty("strDrink")
    private String strDrink;

    @JsonProperty("strInstructions")
    private String strInstructions;

    @JsonProperty("strCategory")
    private String strCategory;

    @JsonProperty("strGlass")
    private String strGlass;

    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;

    // Fields for individual ingredients from the API
    @JsonProperty("strIngredient1")
    private String strIngredient1;

    @JsonProperty("strIngredient2")
    private String strIngredient2;

    @JsonProperty("strIngredient3")
    private String strIngredient3;

    @JsonProperty("strIngredient4")
    private String strIngredient4;

    @JsonProperty("strIngredient5")
    private String strIngredient5;

    @JsonProperty("strIngredient6")
    private String strIngredient6;

    @JsonProperty("strIngredient7")
    private String strIngredient7;

    @JsonProperty("strIngredient8")
    private String strIngredient8;

    @JsonProperty("strIngredient9")
    private String strIngredient9;

    @JsonProperty("strIngredient10")
    private String strIngredient10;

    @JsonProperty("strIngredient11")
    private String strIngredient11;

    @JsonProperty("strIngredient12")
    private String strIngredient12;

    @JsonProperty("strIngredient13")
    private String strIngredient13;

    @JsonProperty("strIngredient14")
    private String strIngredient14;

    @JsonProperty("strIngredient15")
    private String strIngredient15;

    // List to store ingredients
    private List<String> ingredients = new ArrayList<>();

    // No-argument constructor
    public Cocktail() {
    }

    // Getters and setters
    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public List<String> getIngredients() {
        if (ingredients.isEmpty()) {
            collectIngredients();
        }
        return ingredients;
    }

    // Method to collect non-null ingredient fields
    private void collectIngredients() {
        if (strIngredient1 != null) ingredients.add(strIngredient1);
        if (strIngredient2 != null) ingredients.add(strIngredient2);
        if (strIngredient3 != null) ingredients.add(strIngredient3);
        if (strIngredient4 != null) ingredients.add(strIngredient4);
        if (strIngredient5 != null) ingredients.add(strIngredient5);
        if (strIngredient6 != null) ingredients.add(strIngredient6);
        if (strIngredient7 != null) ingredients.add(strIngredient7);
        if (strIngredient8 != null) ingredients.add(strIngredient8);
        if (strIngredient9 != null) ingredients.add(strIngredient9);
        if (strIngredient10 != null) ingredients.add(strIngredient10);
        if (strIngredient11 != null) ingredients.add(strIngredient11);
        if (strIngredient12 != null) ingredients.add(strIngredient12);
        if (strIngredient13 != null) ingredients.add(strIngredient13);
        if (strIngredient14 != null) ingredients.add(strIngredient14);
        if (strIngredient15 != null) ingredients.add(strIngredient15);
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient4(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient5(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient6(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient7(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient8(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient9(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient10(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient11(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient12(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient13(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient14(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }
    public void setStrIngredient15(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

}

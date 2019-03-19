package com.senior_project.recipe_finder.business.domain;

import lombok.Data;

import java.util.List;

@Data
public class LocalRecipe {
    private String label;
    private String image;
    private String url;
    private Integer yield;
    private List<String> ingredientLines;
    private Integer totalTime;
    private Integer matchedIngredients = 0;

    public void increaseUnmatchedIngredientsByOne(){
        matchedIngredients += 1;
    }
}

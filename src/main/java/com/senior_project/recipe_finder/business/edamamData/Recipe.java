package com.senior_project.recipe_finder.business.edamamData;

import lombok.Data;

import java.util.List;


@Data
public class Recipe {
    private String uri;
    private String label;
    private String image;
    private String source;
    private String url;
    private String shareAs;
    private Integer yield;
    private List<String> dietLabels;
    private List<String> healthLabels;
    private List<String> cautions;
    private List<String> ingredientLines;
    private List<Ingredients> ingredients;
    private Float calories;
    private Float totalWeight;
    private Integer totalTime;
}

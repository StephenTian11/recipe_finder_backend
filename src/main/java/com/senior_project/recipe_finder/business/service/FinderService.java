package com.senior_project.recipe_finder.business.service;

import com.senior_project.recipe_finder.business.FinderRestClient;
import com.senior_project.recipe_finder.business.domain.Recipe;
import com.senior_project.recipe_finder.business.edamamData.EdamamResponse;
import com.senior_project.recipe_finder.business.domain.SearchQuery;
import com.senior_project.recipe_finder.business.edamamData.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FinderService {

    @Autowired
    private FinderRestClient finderRestClient;

    public FinderService(){

    }

    public List<Recipe> getQueryResults(SearchQuery searchQuery){
        EdamamResponse result=finderRestClient.getQueryResult(searchQuery);
        List<Recipe> recipes = new ArrayList<>();
        for (Hit h : result.getHits()
             ) {
            Recipe r = new Recipe();
            r.setImage(h.getRecipe().getImage());
            r.setIngredientLines(h.getRecipe().getIngredientLines());
            r.setLabel(h.getRecipe().getLabel());
            r.setTotalTime(h.getRecipe().getTotalTime());
            r.setUrl(h.getRecipe().getUrl());
            r.setYield(h.getRecipe().getYield());
            recipes.add(r);
        }
        


        return recipes;
    }
}

package com.senior_project.recipe_finder.business.service;

import com.senior_project.recipe_finder.business.FinderRestClient;
import com.senior_project.recipe_finder.business.domain.LocalRecipe;
import com.senior_project.recipe_finder.business.edamamData.EdamamResponse;
import com.senior_project.recipe_finder.business.domain.SearchQuery;
import com.senior_project.recipe_finder.business.edamamData.Hit;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FinderService {

    @Autowired
    private FinderRestClient finderRestClient;

    public FinderService(){

    }

    public List<LocalRecipe> getQueryResults(SearchQuery searchQuery, String inventory){
        EdamamResponse result=finderRestClient.getQueryResult(searchQuery);
        List<LocalRecipe> localRecipes = new ArrayList<>();
        for (Hit hit : result.getHits()
             ) {
            LocalRecipe localRecipe = new LocalRecipe();
            localRecipe.setImage(hit.getRecipe().getImage());
            localRecipe.setIngredientLines(hit.getRecipe().getIngredientLines());
            localRecipe.setLabel(hit.getRecipe().getLabel());
            localRecipe.setTotalTime(hit.getRecipe().getTotalTime());
            localRecipe.setUrl(hit.getRecipe().getUrl());
            localRecipe.setYield(hit.getRecipe().getYield());
            localRecipes.add(localRecipe);
        }
        if(inventory != null){
            String[] item = inventory.split(",");
            for (LocalRecipe localRecipe : localRecipes){
                for (String ing : localRecipe.getIngredientLines()){
                    for (String i : item) {
                        if (ing.toLowerCase().contains(i.toLowerCase())){
                            localRecipe.increaseUnmatchedIngredientsByOne();
                        }
                    }
                }
            }

            Collections.sort(localRecipes);
        }
        


        return localRecipes;
    }
}

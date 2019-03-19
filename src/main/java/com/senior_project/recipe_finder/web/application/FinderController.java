package com.senior_project.recipe_finder.web.application;

import com.senior_project.recipe_finder.business.domain.LocalRecipe;
import com.senior_project.recipe_finder.business.service.FinderService;
import com.senior_project.recipe_finder.business.domain.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class FinderController {

    @Autowired
    private FinderService finderService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/recipes")
    public List<LocalRecipe> getSearch(@RequestParam(value = "request") String request,
                                       @RequestParam(value = "ingr", required = false) String ingr,
                                       @RequestParam(value = "diet", required = false) String diet,
                                       @RequestParam(value = "health", required = false) String health,
                                       @RequestParam(value = "calories", required = false) String calories,
                                       @RequestParam(value = "time", required = false) String time,
                                       @RequestParam(value = "inventory", required = false) String inventory){
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.setQuery(request);
        searchQuery.setHealth(health);
        searchQuery.setTime(time);
        searchQuery.setCalories(calories);
        searchQuery.setDiet(diet);
        searchQuery.setIngr(ingr);

        return finderService.getQueryResults(searchQuery,inventory);
    }
}

package com.senior_project.recipe_finder.web.application;

import com.senior_project.recipe_finder.business.domain.Recipe;
import com.senior_project.recipe_finder.business.service.FinderService;
import com.senior_project.recipe_finder.business.domain.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class FinderController {

    @Autowired
    private FinderService finderService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Recipe> getSearch(@RequestParam(value = "request") String request){
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.setQuery(request);
        return finderService.getQueryResults(searchQuery);
    }
}

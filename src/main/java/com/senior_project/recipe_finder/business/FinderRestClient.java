package com.senior_project.recipe_finder.business;

import com.senior_project.recipe_finder.business.edamamData.EdamamResponse;
import com.senior_project.recipe_finder.business.domain.SearchQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinderRestClient {
    public EdamamResponse getQueryResult(SearchQuery searchQuery) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EdamamResponse> responseEntity = restTemplate.getForEntity("https://api.edamam.com/search?app_id=" + searchQuery.getAppId() + "&app_key=" + searchQuery.getAppKey() + "&q=" + searchQuery.getQuery(), EdamamResponse.class);

        return responseEntity.getBody();
    }
}

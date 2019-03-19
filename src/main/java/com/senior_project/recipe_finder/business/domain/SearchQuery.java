package com.senior_project.recipe_finder.business.domain;


import lombok.Data;

@Data
public class SearchQuery {
    private String query;
    private String appId = "369df137";
    private String appKey = "845a0bb6179cb06431b8296ee66dfa85";
    private String from = "0";
    private String to = "50";
    private String ingr;
    private String diet;
    private String health;
    private String calories;
    private String time;

    public String getRequest(){
        String request = "app_id=" + appId + "&app_key=" + appKey + "&q=" + query + "&from=" + from + "&to=" + to;
        if(ingr!=null) request += "&ingr=" + ingr;
        if(diet != null) request += "&diet=" + diet;
        if(health != null) request += "&health=" + health;
        if(calories != null) request += "&calories=" + calories;
        if(time != null) request += "&time=" + time;
        return request;
    }
}

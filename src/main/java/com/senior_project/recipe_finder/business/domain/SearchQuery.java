package com.senior_project.recipe_finder.business.domain;


import lombok.Data;

@Data
public class SearchQuery {
    public String query;
    public String appId = "369df137";
    public String appKey = "845a0bb6179cb06431b8296ee66dfa85";
}

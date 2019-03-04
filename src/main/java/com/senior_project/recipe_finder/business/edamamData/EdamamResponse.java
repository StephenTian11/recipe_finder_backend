package com.senior_project.recipe_finder.business.edamamData;

import lombok.Data;

import java.util.List;


@Data
public class EdamamResponse {
    private String q;
    private Integer from;
    private Integer to;
    private Params params;
    private boolean more;
    private Integer count;
    private List<Hit> hits;
}

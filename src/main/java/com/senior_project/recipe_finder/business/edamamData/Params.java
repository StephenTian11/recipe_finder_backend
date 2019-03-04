package com.senior_project.recipe_finder.business.edamamData;

import lombok.Data;

import java.util.List;

@Data
public class Params {
    private List<String> sane;
    private List<String> q;
    private List<String> app_key;
    private List<String> app_id;
}

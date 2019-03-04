package com.senior_project.recipe_finder.business.edamamData;

import lombok.Data;


@Data
public class Hit {
    private Recipe recipe;
    private Boolean bookmarked;
    private Boolean bought;
}

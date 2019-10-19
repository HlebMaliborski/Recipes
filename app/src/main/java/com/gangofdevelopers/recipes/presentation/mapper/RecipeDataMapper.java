package com.gangofdevelopers.recipes.presentation.mapper;

import com.gangofdevelopers.recipes.domain.model.Recipe;
import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;

public class RecipeDataMapper implements IRecipeDataMapper {
    @Inject
    public RecipeDataMapper() {
    }

    @Override
    public List<RecipeViewData> map(List<Recipe> inputData) {
        List<RecipeViewData> recipes = new ArrayList<>();

        for (Recipe recipe : inputData) {
            RecipeViewData viewData = transform(recipe);
            if (viewData != null) {
                recipes.add(viewData);
            }
        }

        return recipes;
    }

    @Nullable
    private RecipeViewData transform(Recipe recipe) {
        RecipeViewData viewData = null;
        if (recipe != null) {
            viewData = new RecipeViewData();
            viewData.setId(recipe.getId());
            viewData.setDescription(recipe.getDescription());
            viewData.setImageUrl(recipe.getImageUrl());
        }
        return viewData;
    }
}

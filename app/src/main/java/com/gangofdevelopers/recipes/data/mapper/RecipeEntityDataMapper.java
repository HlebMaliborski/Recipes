package com.gangofdevelopers.recipes.data.mapper;

import com.gangofdevelopers.recipes.data.model.RecipeEntity;
import com.gangofdevelopers.recipes.domain.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;

/**
 * Mapper for mapping data from data layer to domain.
 */
public class RecipeEntityDataMapper implements IRecipeEntityDataMapper {
    @Inject
    public RecipeEntityDataMapper() {

    }

    @Override
    public List<Recipe> map(List<RecipeEntity> inputData) {
        List<Recipe> recipes = new ArrayList<>();

        for (RecipeEntity entity : inputData) {
            Recipe recipe = transform(entity);
            if (recipe != null) {
                recipes.add(recipe);
            }
        }

        return recipes;
    }

    @Nullable
    private Recipe transform(RecipeEntity entity) {
        Recipe recipe = null;
        if (entity != null) {
            recipe = new Recipe();
            recipe.setId(entity.getId());
            recipe.setDescription(entity.getDescription());
            recipe.setImageUrl(entity.getImageUrl());
        }
        return recipe;
    }
}

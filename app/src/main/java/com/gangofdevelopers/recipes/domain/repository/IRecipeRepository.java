package com.gangofdevelopers.recipes.domain.repository;

import com.gangofdevelopers.recipes.domain.model.Recipe;

import java.util.List;

import io.reactivex.Observable;

/**
 * As our domain layer should be independent as it has common business logic we should provide interface
 * which helps retrieve data from data layer.
 */
public interface IRecipeRepository {
    Observable<List<Recipe>> getRecipes();
}

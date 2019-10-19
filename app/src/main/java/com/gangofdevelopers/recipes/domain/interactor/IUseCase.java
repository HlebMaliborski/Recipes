package com.gangofdevelopers.recipes.domain.interactor;

import com.gangofdevelopers.recipes.domain.model.Recipe;

import java.util.List;

import io.reactivex.Observable;

/**
 * Its simple version of UseCase. We should make it more generic to use it with any type of data.
 */
public interface IUseCase {
    Observable<List<Recipe>> getRecipes();
}

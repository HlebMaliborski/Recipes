package com.gangofdevelopers.recipes.domain.interactor;

import com.gangofdevelopers.recipes.domain.model.Recipe;
import com.gangofdevelopers.recipes.domain.repository.IRecipeRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * USe case for recipes. There is should be all independent business logic.
 */
public class GetRecipesUseCase implements IUseCase {
    private IRecipeRepository repository;

    @Inject
    public GetRecipesUseCase(IRecipeRepository repositoryImpl) {
        repository = repositoryImpl;
    }

    @Override
    public Observable<List<Recipe>> getRecipes() {
        return repository.getRecipes();
    }
}

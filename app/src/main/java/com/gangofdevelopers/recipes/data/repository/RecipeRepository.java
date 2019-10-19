package com.gangofdevelopers.recipes.data.repository;

import com.gangofdevelopers.recipes.data.datasource.INetworkDataSource;
import com.gangofdevelopers.recipes.data.mapper.IRecipeEntityDataMapper;
import com.gangofdevelopers.recipes.domain.model.Recipe;
import com.gangofdevelopers.recipes.domain.repository.IRecipeRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Repository class to incapsulate logic of getting necessary data.
 * We can use here several datasources.
 */
public class RecipeRepository implements IRecipeRepository {
    private INetworkDataSource dataSource;
    private IRecipeEntityDataMapper dataMapper;

    @Inject
    public RecipeRepository(INetworkDataSource dataSource, IRecipeEntityDataMapper dataMapper) {
        this.dataSource = dataSource;
        this.dataMapper = dataMapper;
    }

    @Override
    public Observable<List<Recipe>> getRecipes() {
        return dataSource.loadRecipes().map(dataMapper::map);
    }
}

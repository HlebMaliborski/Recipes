package com.gangofdevelopers.recipes.data.datasource;

import com.gangofdevelopers.recipes.data.model.RecipeEntity;

import java.util.List;

import io.reactivex.Observable;

public interface INetworkDataSource {
    Observable<List<RecipeEntity>> loadRecipes();
}

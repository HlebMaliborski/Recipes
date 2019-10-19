package com.gangofdevelopers.recipes.data.di;

import com.gangofdevelopers.recipes.data.datasource.INetworkDataSource;
import com.gangofdevelopers.recipes.data.datasource.NetworkDataSource;
import com.gangofdevelopers.recipes.data.mapper.IRecipeEntityDataMapper;
import com.gangofdevelopers.recipes.data.mapper.RecipeEntityDataMapper;
import com.gangofdevelopers.recipes.data.repository.RecipeRepository;
import com.gangofdevelopers.recipes.domain.repository.IRecipeRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {
    @Singleton
    @Binds
    abstract IRecipeRepository bindsRecipesRepository(RecipeRepository repository);

    @Singleton
    @Binds
    abstract INetworkDataSource bindsNetworkDataSource(NetworkDataSource dataSource);

    @Singleton
    @Binds
    abstract IRecipeEntityDataMapper bindsRecipeEntityDataMapper(RecipeEntityDataMapper dataMapper);
}

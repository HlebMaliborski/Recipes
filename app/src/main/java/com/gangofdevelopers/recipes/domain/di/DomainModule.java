package com.gangofdevelopers.recipes.domain.di;

import com.gangofdevelopers.recipes.domain.interactor.GetRecipesUseCase;
import com.gangofdevelopers.recipes.domain.interactor.IUseCase;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DomainModule {
    @Singleton
    @Binds
    abstract IUseCase bindsRecipesUseCase(GetRecipesUseCase useCase);
}

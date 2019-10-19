package com.gangofdevelopers.recipes.presentation.di;

import com.gangofdevelopers.recipes.presentation.mapper.IRecipeDataMapper;
import com.gangofdevelopers.recipes.presentation.mapper.RecipeDataMapper;
import com.gangofdevelopers.recipes.presentation.viewmodel.DetailRecipeViewModel;
import com.gangofdevelopers.recipes.presentation.viewmodel.MasterRecipeViewModel;
import com.gangofdevelopers.recipes.presentation.viewmodel.ViewModelFactory;
import com.gangofdevelopers.recipes.presentation.viewmodel.ViewModelKey;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MasterRecipeViewModel.class)
    abstract ViewModel bindsMasterRecipeViewModel(MasterRecipeViewModel masterRecipeViewModel);

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(DetailRecipeViewModel.class)
    abstract ViewModel bindsDetailRecipeViewModel(DetailRecipeViewModel detailRecipeViewModel);

    @Singleton
    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory factory);

    @Singleton
    @Binds
    abstract IRecipeDataMapper bindsRecipeDataMapper(RecipeDataMapper mapper);
}
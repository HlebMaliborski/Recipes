package com.gangofdevelopers.recipes.presentation.di;

import com.gangofdevelopers.recipes.presentation.view.DetailRecipeFragment;
import com.gangofdevelopers.recipes.presentation.view.MasterRecipeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract MasterRecipeFragment provideMasterFragment();

    @ContributesAndroidInjector
    abstract DetailRecipeFragment provideDetailFragment();
}

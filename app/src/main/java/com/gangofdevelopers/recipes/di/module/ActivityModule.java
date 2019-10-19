package com.gangofdevelopers.recipes.di.module;

import com.gangofdevelopers.recipes.MainActivity;
import com.gangofdevelopers.recipes.presentation.di.FragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = {FragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}

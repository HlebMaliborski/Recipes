package com.gangofdevelopers.recipes.di.component;

import android.app.Application;

import com.gangofdevelopers.recipes.App;
import com.gangofdevelopers.recipes.data.di.DataModule;
import com.gangofdevelopers.recipes.di.module.ActivityModule;
import com.gangofdevelopers.recipes.domain.di.DomainModule;
import com.gangofdevelopers.recipes.presentation.di.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

//In future its have to create separate scopes for screen/feature and so on.
//Right now I use make all object Singleton, just for test.
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityModule.class,
        ViewModelModule.class,
        DomainModule.class,
        DataModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(App application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

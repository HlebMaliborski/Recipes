package com.gangofdevelopers.recipes.presentation.viewmodel;

import com.gangofdevelopers.recipes.domain.interactor.IUseCase;
import com.gangofdevelopers.recipes.presentation.mapper.IRecipeDataMapper;
import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * We can use here only liveData without RxJava, but it would be better to use it with coroutines and kotlin.
 */
public class MasterRecipeViewModel extends ViewModel {
    private IUseCase useCase;
    private IRecipeDataMapper mapper;

    //We can create common class to handle disposable logic inside.
    private CompositeDisposable disposable;

    //We should incapsulate those fields as we shouldn't have possibility to set them in fragment/activity.
    private final MutableLiveData<List<RecipeViewData>> recipes = new MutableLiveData<>();
    //We can handle exceptions wit this field, but right now its not necessary
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public MasterRecipeViewModel(IUseCase useCase, IRecipeDataMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
        disposable = new CompositeDisposable();

        loadRecipes();
    }

    public void loadRecipes() {
        loading.setValue(true);
        disposable.add(useCase.getRecipes()
                .map(mapper::map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<RecipeViewData>>() {
                    @Override
                    public void onNext(List<RecipeViewData> recipeViewData) {
                        loadError.setValue(false);
                        recipes.setValue(recipeViewData);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadError.setValue(true);
                        loading.setValue(false);
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

    public LiveData<List<RecipeViewData>> getRecipes() {
        return recipes;
    }

    public LiveData<Boolean> getError() {
        return loadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }
}

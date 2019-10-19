package com.gangofdevelopers.recipes.data.datasource;

import com.gangofdevelopers.recipes.data.model.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Some datasource class to receive data from network. In real project we should use
 * retrofit/volley or something else with appropriate DTO class for json, but
 * right now we just emulate the logic and we use here RecipeEntity instead.
 */
public class NetworkDataSource implements INetworkDataSource {
    @Inject
    public NetworkDataSource() { }

    @Override
    public Observable<List<RecipeEntity>> loadRecipes() {
        return getObservableData();
    }

    private Observable<List<RecipeEntity>> getObservableData() {
        return Observable.fromArray(emulateData());
    }

    private List<RecipeEntity> emulateData() {
        List<RecipeEntity> recipes = new ArrayList<>();

        RecipeEntity recipe1 = new RecipeEntity();
        recipe1.setId("1");
        recipe1.setDescription("Smoky Pork Tortillas");
        recipe1.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/11985403.jpg");
        recipes.add(recipe1);

        RecipeEntity recipe2 = new RecipeEntity();
        recipe2.setId("2");
        recipe2.setDescription("Simple Tossed Salad");
        recipe2.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/11986497.jpg");
        recipes.add(recipe2);

        RecipeEntity recipe3 = new RecipeEntity();
        recipe3.setId("3");
        recipe3.setDescription("Garlic Lemon Salmon");
        recipe3.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/11988733.jpg");
        recipes.add(recipe3);

        RecipeEntity recipe4 = new RecipeEntity();
        recipe4.setId("4");
        recipe4.setDescription("Recipe 4");
        recipe4.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/11989088.jpg");
        recipes.add(recipe4);

        RecipeEntity recipe5 = new RecipeEntity();
        recipe5.setId("5");
        recipe5.setDescription("Recipe 5");
        recipe5.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12153487.jpg");
        recipes.add(recipe5);

        RecipeEntity recipe6 = new RecipeEntity();
        recipe6.setId("6");
        recipe6.setDescription("Recipe 6");
        recipe6.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12167354.jpg");
        recipes.add(recipe6);

        RecipeEntity recipe7 = new RecipeEntity();
        recipe7.setId("7");
        recipe7.setDescription("Recipe 7");
        recipe7.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12231705.jpg");
        recipes.add(recipe7);

        RecipeEntity recipe8 = new RecipeEntity();
        recipe8.setId("8");
        recipe8.setDescription("Recipe 8");
        recipe8.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12362599.jpg");
        recipes.add(recipe8);

        RecipeEntity recipe9 = new RecipeEntity();
        recipe9.setId("9");
        recipe9.setDescription("Recipe 9");
        recipe9.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12369258.jpg");
        recipes.add(recipe9);

        RecipeEntity recipe10 = new RecipeEntity();
        recipe10.setId("10");
        recipe10.setDescription("Recipe 10");
        recipe10.setImageUrl("https://s3.amazonaws.com/img.mynetdiary.com/PremiumRecipePictures/hi-res/12409611.jpg");
        recipes.add(recipe10);

        return recipes;
    }
}

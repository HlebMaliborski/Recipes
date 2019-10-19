package com.gangofdevelopers.recipes.presentation.view;

import android.widget.ImageView;
import android.widget.TextView;

import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;

public interface RecipeClickListener {
    void onCLick(ImageView image, TextView text, RecipeViewData data);
}

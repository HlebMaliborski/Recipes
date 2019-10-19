package com.gangofdevelopers.recipes.presentation.mapper;

import com.gangofdevelopers.recipes.common.IMapper;
import com.gangofdevelopers.recipes.domain.model.Recipe;
import com.gangofdevelopers.recipes.presentation.model.RecipeViewData;

import java.util.List;

public interface IRecipeDataMapper extends IMapper<List<RecipeViewData>, List<Recipe>> { }

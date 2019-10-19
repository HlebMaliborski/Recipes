package com.gangofdevelopers.recipes.data.mapper;

import com.gangofdevelopers.recipes.common.IMapper;
import com.gangofdevelopers.recipes.data.model.RecipeEntity;
import com.gangofdevelopers.recipes.domain.model.Recipe;

import java.util.List;

public interface IRecipeEntityDataMapper extends IMapper<List<Recipe>, List<RecipeEntity>> {}

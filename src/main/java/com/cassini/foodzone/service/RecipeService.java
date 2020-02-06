package com.cassini.foodzone.service;

import java.util.List;

import com.cassini.foodzone.dto.AddRecipeRequest;
import com.cassini.foodzone.dto.AddRecipeResponseDto;
import com.cassini.foodzone.dto.EditRecipeResponseDto;
import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.exception.NotFoundException;

public interface RecipeService {
	
	public List<Recipe> getAllRecipes(Integer vendorId);
	
	public AddRecipeResponseDto addRecipe(AddRecipeRequest addRecipeRequest);
	
	public EditRecipeResponseDto editRecipe(Integer recipeId) throws NotFoundException;

}

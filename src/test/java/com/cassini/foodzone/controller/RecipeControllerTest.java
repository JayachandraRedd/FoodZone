package com.cassini.foodzone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.foodzone.dto.AddRecipeRequest;
import com.cassini.foodzone.dto.AddRecipeResponseDto;
import com.cassini.foodzone.dto.EditRecipeResponseDto;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.service.RecipeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RecipeControllerTest {
	

	@InjectMocks
	RecipeController recipeController;

	@Mock
	RecipeService recipeService;
	
	@Test(expected = NotFoundException.class)
	public void testGetRecipesException() throws NotFoundException {
		recipeController.getRecipes(null);
	}
	
	@Test
	public void testGetRecipesSuccess() throws NotFoundException {
		Mockito.when(recipeService.getAllRecipes(1)).thenReturn(new ArrayList<>());
		Integer actual = recipeController.getRecipes(1).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddRecipeSuccess(){
		Mockito.when(recipeService.addRecipe(Mockito.any())).thenReturn(new AddRecipeResponseDto());
		Integer actual = recipeController.addRecipe(new AddRecipeRequest()).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEditRecipeSuccess() throws NotFoundException{
		Mockito.when(recipeService.editRecipe(Mockito.any())).thenReturn(new EditRecipeResponseDto());
		Integer actual = recipeController.editRecipe(1).getStatusCodeValue();
		Integer expected = 200;
		assertEquals(expected, actual);
	}

}

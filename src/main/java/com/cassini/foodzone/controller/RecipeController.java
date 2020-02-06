package com.cassini.foodzone.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.foodzone.dto.AddRecipeRequest;
import com.cassini.foodzone.dto.AddRecipeResponseDto;
import com.cassini.foodzone.dto.EditRecipeResponseDto;
import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.service.RecipeService;
import com.cassini.foodzone.util.Constant;

import lombok.extern.slf4j.Slf4j;

/**
 * This Controller is having the Recipe related functionalities. This
 * Controller will call the recipeService in which the implementations are
 * done.
 * 
 * @API It has a method which will get the recipes.
 * @author Raghib
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/vendors/{vendorId}/recipes")
@Slf4j
public class RecipeController {
	
	/**
	 * This will inject all the implementations in the recipeService.
	 */
	@Autowired
	RecipeService recipeService;
	
	/**
	 * @author Raghib
	 * 
	 *         this API is used to get the recipes using vendorId
	 *         
	 * 
	 * @param vendorId.
	 * @return list of recipes.
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping
	public ResponseEntity<List<Recipe>> getRecipes(@PathVariable("vendorId") Integer vendorId) throws NotFoundException
	{
		log.info("Calling getRecipes() method from VendorController");
		if(vendorId == null)
		{
			throw new NotFoundException(Constant.VENDOR_NOT_FOUND);
			
		}
		return ResponseEntity.ok().body(recipeService.getAllRecipes(vendorId));
		
	}
	
	@PostMapping
	public ResponseEntity<AddRecipeResponseDto> addRecipe(@RequestBody AddRecipeRequest addRecipeRequest) {
		
		return ResponseEntity.ok().body(recipeService.addRecipe(addRecipeRequest));
	}
	
	@PutMapping("/{recipeId}")
	public ResponseEntity<EditRecipeResponseDto> editRecipe(@PathParam("recipeId") Integer recipeId) throws NotFoundException {
		EditRecipeResponseDto editRecipeResponseDto = recipeService.editRecipe(recipeId);
		editRecipeResponseDto.setMessage("changes happend");
		editRecipeResponseDto.setStatusCode(HttpStatus.ACCEPTED.value());
		return ResponseEntity.ok().body(editRecipeResponseDto);
		
	}

}

package com.cassini.foodzone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.service.RecipeService;

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
	 * @throws LocationNotFoundException
	 * 
	 */
	@GetMapping
	public ResponseEntity<List<Recipe>> getRecipes(@PathVariable("vendorId") Integer vendorId)
	{
		log.info("Calling getRecipes() method from VendorController");
		if(vendorId == 0 || vendorId == null)
		{
			
		}
		return ResponseEntity.ok().body(recipeService.getAllRecipes(vendorId));
		
	}

}

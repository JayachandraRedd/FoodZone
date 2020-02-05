package com.cassini.foodzone.service;

import java.util.List;

import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;

public interface RecipeService {
	
	public List<Recipe> getAllRecipes(Integer vendorId);

}

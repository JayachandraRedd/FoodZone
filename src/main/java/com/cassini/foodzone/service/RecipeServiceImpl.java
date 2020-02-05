package com.cassini.foodzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;
import com.cassini.foodzone.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Override
	public List<Recipe> getAllRecipes(Integer vendorId) {
		
		Vendor vendor = new Vendor();
		vendor.setVendorId(vendorId);
		return recipeRepository.findByVendor(vendor);
	}

}

package com.cassini.foodzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.foodzone.entity.Recipe;
import com.cassini.foodzone.entity.Vendor;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	List<Recipe> findByVendor(Vendor vendor);
}

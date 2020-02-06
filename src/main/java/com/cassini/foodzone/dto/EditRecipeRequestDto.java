package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRecipeRequestDto {
	
	private Integer vendorId;
	private Integer recipeId;

}

package com.cassini.foodzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRecipeResponseDto {
	
	private String message;
	private Integer statusCode;
	private Integer recipeId;

}

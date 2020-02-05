package com.cassini.foodzone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@SequenceGenerator(name = "recipeId", initialValue = 1, allocationSize = 1)
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeId")
	private Integer recipeId;
	private String recipeName;
	private Double unitPrice;
	
	@ManyToOne
	private Vendor vendor;
	
}

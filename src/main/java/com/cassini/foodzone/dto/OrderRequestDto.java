package com.cassini.foodzone.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
	
	private Integer customerId;
	private List<Integer> recipes;

}

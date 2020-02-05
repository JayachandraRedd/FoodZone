package com.cassini.foodzone.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@SequenceGenerator(name = "orderId", initialValue = 1, allocationSize = 1)
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId")
	private Integer orderId;
	
	private String orderStatus;
	
	@OneToMany
	private List<Recipe> recipes;
	
	private LocalDate date;

}

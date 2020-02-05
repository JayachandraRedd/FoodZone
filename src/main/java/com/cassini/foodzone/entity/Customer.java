package com.cassini.foodzone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@SequenceGenerator(name = "customerId", initialValue = 1, allocationSize = 1)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId")
	private Integer customerId;
	private String customerName;
	private String password;
	private String email;
	private Long phoneNumber;

}

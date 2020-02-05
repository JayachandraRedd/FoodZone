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
@SequenceGenerator(name = "vendorId", initialValue = 100, allocationSize = 1)
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendorId")
	private Integer vendorId;
	private String vendorName;
	private String password;
	private String email;
	private Long phoneNumber;

}

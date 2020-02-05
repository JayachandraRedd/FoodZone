package com.cassini.foodzone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment {
	@Id
	private Integer paymentId;
	private String paymentName;

}

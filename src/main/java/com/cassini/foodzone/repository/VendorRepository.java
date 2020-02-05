package com.cassini.foodzone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.foodzone.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	
	Optional<Vendor> findByEmailAndPassword(String email, String password);

}

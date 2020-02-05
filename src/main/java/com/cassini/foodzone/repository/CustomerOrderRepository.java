package com.cassini.foodzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.foodzone.entity.Customer;
import com.cassini.foodzone.entity.CustomerOrder;
import com.cassini.foodzone.entity.Vendor;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer>{


	List<CustomerOrder> findByCustomer(Customer customer);

	List<CustomerOrder> findByVendorAndOrderStatus(Vendor vendor, String status);
	
	

}

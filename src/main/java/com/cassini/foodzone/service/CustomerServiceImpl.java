package com.cassini.foodzone.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cassini.foodzone.dto.LoginRequestDto;
import com.cassini.foodzone.dto.LoginResponseDto;
import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.entity.Customer;
import com.cassini.foodzone.exception.NotFoundException;
import com.cassini.foodzone.repository.CustomerRepository;
import com.cassini.foodzone.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public ResponseDto registration(RegistrationDto registrationDto) {
		Customer customer=new Customer();
		ResponseDto responseDto=new ResponseDto();
		
		if (!registrationDto.equals(null)) {
			BeanUtils.copyProperties(registrationDto, customer);
			customerRepository.save(customer);
			responseDto.setMessage(Constant.CUSTOMER_REGISTRATION_SUCCESSFULL);
			responseDto.setStatusCode(HttpStatus.OK.value());
			return responseDto;
		} else {
			responseDto.setMessage(Constant.CUSTOMER_REGISTRATION_FAIL);
			responseDto.setStatusCode(HttpStatus.OK.value());
			return responseDto;
		}
		
		
	}

	@Override
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException {
		log.info("CustomerServiceImpl authenticateCustomer ---> autheticating customer");
		Optional<Customer> customer = customerRepository.findByEmailAndPassword(loginRequestDto.getEmail(),
				loginRequestDto.getPassword());
		if (customer.isPresent()) {
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			BeanUtils.copyProperties(customer.get(), loginResponseDto);
			loginResponseDto.setId(customer.get().getCustomerId());
			loginResponseDto.setName(customer.get().getCustomerName());
			log.info("CustomerServiceImpl authenticateCustomer ---> customer signed in");
			return loginResponseDto;
		} else {
			log.error("CustomerServiceImpl authenticateCustomer ---> NotFoundException occured");
			throw new NotFoundException(Constant.CUSTOMER_NOT_FOUND);
		}
	}

}

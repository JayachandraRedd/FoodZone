package com.cassini.foodzone.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.cassini.foodzone.dto.RegistrationDto;
import com.cassini.foodzone.dto.ResponseDto;
import com.cassini.foodzone.entity.Customer;
import com.cassini.foodzone.exception.RegistrationFailedExcpetion;
import com.cassini.foodzone.repository.CustomerRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
	
	
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void testRegisterPossitive() throws RegistrationFailedExcpetion {
		
		
		RegistrationDto registrationDto = new RegistrationDto();
		registrationDto.setCustomerName("amala");
		registrationDto.setEmail("amala@gmail.com");
		registrationDto.setPassword("sweetysandy");
        registrationDto.setPhoneNumber(7680920258L);		
		
       Customer customer=new Customer();
       BeanUtils.copyProperties(registrationDto, customer);
       
       Mockito.when(customerRepository.save(customer)).thenReturn(customer);
      
       ResponseDto userregistration = customerServiceImpl.registration(registrationDto);
       Assert.assertNotNull(userregistration);
		Assert.assertEquals(userregistration.getMessage(), "Customer Registration successfull !!");

       
       
	}
	
	
	@Test(expected = RegistrationFailedExcpetion.class)
	public void testRegisterException() throws RegistrationFailedExcpetion {

		RegistrationDto registrationDto = new RegistrationDto();
		registrationDto.setCustomerName(null);
		Customer customer = new Customer();
		BeanUtils.copyProperties(registrationDto, customer);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		ResponseDto usersRegister = customerServiceImpl.registration(registrationDto);

	}

}

package com.cassini.foodzone;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cassini.foodzone.service.PaymentRegistery;

@SpringBootApplication
public class FoodzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodzoneApplication.class, args);
	}

	@Bean
	public ServiceLocatorFactoryBean getBean() {
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(PaymentRegistery.class);
		return bean;
	}

}

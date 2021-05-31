package com.Santander.Santander;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component

public class BusinessFillingRunner implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessFillingRunner.class);

	@Autowired
	BusinessRepository businessRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Faker generador = new Faker();
		int i=100000;
		
		ArrayList<Business> list =  new ArrayList<Business>();
		
		if(businessRepository.count() < 0) 			{
			while(i<100100) {
				Business business = new Business(generador.business());
				list.add(business);
				Business crearObjeto = new Business("i"+i, generador.business());
				businessRepository.save(crearObjeto);	
			list.removeAll(list);
			i++;

							}
										}

		businessRepository.findAll().forEach((business) -> {
	logger.info("{}", business);
	}
	);
	}
	
}
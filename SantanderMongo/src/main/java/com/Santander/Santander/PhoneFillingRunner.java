package com.Santander.Santander;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component

public class PhoneFillingRunner implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(NameFillingRunner.class);

@Autowired
	PhoneNumberRepository phoneNumberRepository;


@Override
public void run(String... args) throws Exception {
	
	Faker generador = new Faker();
	int i=100000;
	
	ArrayList<PhoneNumber> list =  new ArrayList<PhoneNumber>();
	
	if(phoneNumberRepository.count() < 0) 			{
		while(i<100100) {
			PhoneNumber phoneNumber = new PhoneNumber(generador.phoneNumber().cellPhone());
			list.add(phoneNumber);
			PhoneNumber crearObjeto = new PhoneNumber("i"+i, generador.phoneNumber());
			phoneNumberRepository.save(crearObjeto);	
		list.removeAll(list);
		i++;

						}
									}

	phoneNumberRepository.findAll().forEach((phonenumber) -> {
logger.info("{}", phonenumber);
}
);
}
}

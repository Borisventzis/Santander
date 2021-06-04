package com.Santander.Santander;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class NameFillingRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(NameFillingRunner.class);

	@Autowired
	NameRepository nameRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Faker generador = new Faker();
		int i=100000;
		
		ArrayList<Address> list =  new ArrayList<Address>();
		
		
			//if(nameRepository.count() < 0) 			{
			
			  while(i<101000) { Address address = new
			  Address(generador.address().fullAddress()); list.add(address);
			  
			  PhoneNumber phone = new PhoneNumber(); phone.setDNI("i"+i);
			  phone.setCellPhone(generador.phoneNumber().cellPhone());
			  
			  Job trabajo = new Job(); trabajo.setDNI("i"+i);
			  trabajo.setKeySkills(generador.job().keySkills());
			  trabajo.setPosition(generador.job().position());
			  trabajo.setSeniority(generador.job().seniority());
			  trabajo.setTitle(generador.job().title());
			  
			  Business tarjeta = new Business(); tarjeta.setDNI("i"+i);
			  tarjeta.setCreditCardExpiry(generador.business().creditCardExpiry());
			  tarjeta.setCreditCardNumber(generador.business().creditCardNumber());
			  tarjeta.setCreditCardType(generador.business().creditCardType());
			  
			  Name crearObjeto = new Name("i"+i, generador.name().firstName(),
			  generador.name().lastName(),trabajo, tarjeta ,phone,list);
			  nameRepository.save(crearObjeto); list.removeAll(list); i++;
			  
			  }
			 
										//		}
		
		//nameRepository.deleteAll();
		nameRepository.findAll().forEach((Name) -> {
			logger.info("{}", Name);
		}
	);
	}
}
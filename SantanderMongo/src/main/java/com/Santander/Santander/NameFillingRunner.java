package com.Santander.Santander;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
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
		
		
			if(nameRepository.count() < 0) 			{
					while(i<100100) {
						Address address = new Address(generador.address().fullAddress());
						list.add(address);
					Name crearObjeto = new Name("i"+i, generador.name().firstName(), generador.name().lastName(),list);
					nameRepository.save(crearObjeto);	
					list.removeAll(list);
					i++;
			
									}
												}
		
	//	nameRepository.deleteAll();
		nameRepository.findAll().forEach((book) -> {
			logger.info("{}", book);
		}
	);
	}
}

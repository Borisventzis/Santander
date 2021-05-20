package com.Santander.Santander;

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

		
		while(i<100100) {
			if(nameRepository.count() < 0) {
				break;
			}else {
			
			Name crearObjeto = new Name(i, generador.name().firstName(), generador.name().lastName());
			nameRepository.save(crearObjeto);	

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

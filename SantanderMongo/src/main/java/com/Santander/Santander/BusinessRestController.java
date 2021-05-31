package com.Santander.Santander;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/webapi")
public class BusinessRestController {

	@Autowired
	BusinessRepository servicio;
	
	
	@GetMapping("/Business")
	public Iterable<Business>ObtenerDatos() {
		
		return servicio.findAll();
		
	}
	
	
	@PostMapping(path="/newBusiness", consumes="application/json")
	void newBusiness(@RequestBody Business business) {
		
		servicio.save(business);
	}
	
	
	@DeleteMapping("/delBusiness/{DNI}")
	public void DeleteChamp(@PathVariable String DNI) {
		if (servicio.findById(DNI) != null) {
			servicio.deleteById(DNI);
		}
	}
	
	
	@PutMapping("/updateBusiness/{DNI}")
	public Optional<Business> updateBusiness(@RequestBody Business business,  @PathVariable String DNI) {
		Optional<Business> Business = servicio.findById(DNI);
		
		if (Business.isPresent()) {
			Business.get().setCreditCardNumber(Business.get());
			servicio.save(Business.get());
			return Business;
			
		} else {
			
			return Business;
		}
			
	}
	
}

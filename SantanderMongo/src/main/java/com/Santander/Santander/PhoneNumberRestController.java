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
public class PhoneNumberRestController {

	@Autowired
	PhoneNumberRepository servicio;
	
	@GetMapping("/PhoneNumber")
	public Iterable<PhoneNumber>ObtenerDatos() {
		
		return servicio.findAll();
		
	}
	
	@PostMapping(path="/newPhoneNumber", consumes="application/json")
	void newPhoneNumber(@RequestBody PhoneNumber phonenumber) {
		
		servicio.save(phonenumber);
	}
	
	@DeleteMapping("/delPhoneNumber/{DNI}")
	public void DeletePN(@PathVariable String DNI) {
		if (servicio.findById(DNI) != null) {
			servicio.deleteById(DNI);
		}
	}
	
	
	@PutMapping("/updatePhoneNumber/{DNI}")
	public Optional<PhoneNumber> updatePhoneNumber(@RequestBody PhoneNumber phoneNumber,  @PathVariable String DNI) {
		Optional<PhoneNumber> PhoneNumber = servicio.findById(DNI); 
	
	if (PhoneNumber.isPresent()) {
		PhoneNumber.get().setCellPhone(phoneNumber.getCellPhone());
		
		servicio.save(PhoneNumber.get());
		return PhoneNumber;
	}
	else {
		
		return PhoneNumber;
	}
			
	}
}
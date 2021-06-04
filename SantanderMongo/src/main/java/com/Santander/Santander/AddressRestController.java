package com.Santander.Santander;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class AddressRestController {

	
	@Autowired
	AddressRepository servicio;
	
	@GetMapping("/Address")
	public Iterable<Address> ObtenerDatos() {

		return servicio.findAll();
		
	}
	
	@PostMapping(path="/nuevoAddress", consumes="application/json")
	 void NuevoAddress(@RequestBody Address address) {
	 
			servicio.save(address);	
	}
	

@DeleteMapping("/eliminarAddress/{DNI}")	
public void DeleteAddress(@PathVariable String DNI) {
		if (servicio.findById(DNI) != null) {
			servicio.deleteById(DNI);
			
		}
		
}


@PutMapping("/actualizarAddress/{dni}")
public Optional<Address> updateAddress(@RequestBody Address address, @PathVariable String dni) {
	Optional<Address> Address = servicio.findById(dni);

	if (Address.isPresent()) {

		Address.get().setDNI(address.getDNI());
		Address.get().setCity(address.getCity());
		Address.get().setState(address.getState());
		Address.get().setStreetAddressNumber(address.getStreetAddressNumber());
		Address.get().setStreetName(address.getStreetName());
		Address.get().setZipCode(address.getZipCode());
		Address.get().setFullAddress(address.getFullAddress());

		servicio.save(Address.get());
		return Address;
	} else {
	
	return Address;}
}
	
}

package com.Santander.Santander;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class NameRestController {

	
	@Autowired
	NameRepository serviciorest;
	//@Autowired
	//SanService service;
	
	@GetMapping("/Usuarios")
	public Iterable<Name> ObtenerDatos() {

		return serviciorest.findAll();
	}
	
@PostMapping(path="/nuevoUsuario", consumes="application/json")
 void NuevoCampeon(@RequestBody Name name) {
		serviciorest.save(name);
		
}

@DeleteMapping("/eliminarUsuario/{DNI}")	
public void DeleteChamp(@PathVariable long DNI) {
		if (serviciorest.findById(DNI) != null) {
			serviciorest.deleteById(DNI);;
			
		}
		
}
		
		

}
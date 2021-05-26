package com.Santander.Santander;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/Santander")
public class AddressController {

	@Autowired
	AddressRepository servicio;
	//SanService servicio;
	@RequestMapping("/Direcciones")
	public String ObtenerDatos(Model model) {
		model.addAttribute("EtiquetaBD",servicio.findAll());
		return "Usuarios";
	}
	
	 @RequestMapping("/newAddress") public String newAddress(Address address ,Model model) {
			  
				 servicio.save(address);
			  
			  return "redirect:/Santander/Address"; 
			  }
	
	  @RequestMapping("/nuevaDireccion") public String NuevoUsuario(Model model) {
	  
		 // servicio.save(name);
	  
	  return "nuevadireccion"; }
	
	  
	  @RequestMapping("/eliminarDireccion")
	  public String EliminarDireccion(@RequestParam("DireccionEliminar") long dni, Model model) {
	
		  Optional<Address> address = servicio.findById(dni);

		  if (address.isPresent()) {
			  servicio.deleteById(dni);
			  model.addAttribute("EtiquetaBD",servicio.findAll()); 
			  return  "DeletedAddress";
		  							}
	  
		  			else { 
		  			return "AddressNotFound";
		  					}
		  
	  }
	  
	  @PostMapping("/reemplazarDireccion/{DireccionActualizar}") 
	  public String Update(@PathVariable("DireccionActualizar") long dni ,Address address ,Model model) {
	
		  Optional<Address> direccion = servicio.findById(dni);
	  
	  if (direccion.isPresent()) {
				
				servicio.deleteById(dni);
				
				servicio.save(address);
			
				return "redirect:/Santander/Address";
	  							} 
					  else
					  { 
						  System.out.println("No encuentra la direccion"); 
						  return "addressNotFound"; 
					  }
	  }
	  
	  @RequestMapping("/actualizar")
	  public String UpdateChamp(@RequestParam("UsuarioActualizar") long dni, Model model) {
		 Optional<Address> address = servicio.findById(dni);
		 
		  	if (address.isPresent()) {
		  		
		  	model.addAttribute("addressFromDB", address.get());
		    return "ActualizarUsuario";						
		  								}
		  	else
		  		{
		  								
		  			return "addressNotFound";
		  		}
	
	  																							}																		
	 
	
	}


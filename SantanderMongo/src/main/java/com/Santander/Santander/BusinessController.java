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

public class BusinessController {

	@Autowired
	BusinessRepository servicio;

	//Lista Tarjetas

	@RequestMapping("/Business")
	public String ObtenerDatos(Model model) {
		model.addAttribute("EtiquetaBD",servicio.findAll());
		return "Business";
	}
	
	//Añade Tarjetas
	@RequestMapping("/newBusiness") public String newBusiness(Business business ,Model model) {
		  
		 servicio.save(business);
	 
	 return "redirect:/Santander/Business"; 
	 }
	
	
	@RequestMapping("/nuevoBusiness") public String NuevoBusiness(Model model) {

		return "nuevobusiness"; }
	
	
	//Elimina Tarjetas

	@RequestMapping("/eliminarBusiness")
	public String EliminarBusiness(@RequestParam("BusinessEliminar") String dni, Model model) {

		  Optional<Business> business = servicio.findById(dni);

		  if (business.isPresent()) {
			  servicio.deleteById(dni);
			  model.addAttribute("EtiquetaBD",servicio.findAll()); 
			  return  "DeleteBusiness";
		  							}

		  			else { 
		  			return "BusinessNotFound";}
	}
	
	
	//Actualiza Tarjeta

	@PostMapping("/reemplazarBusiness{BusinessActualizar}") 
	public String Update(@PathVariable("BusinessActualizar") String dni ,Business business ,Model model) {

		  Optional<Business> Business = servicio.findById(dni);

	if (Business.isPresent()) {
				
				servicio.deleteById(dni);
				
				servicio.save(business);
			
				return "redirect:/Santander/Business";
								} 
					  else
					  { 
						  System.out.println("No encuentra el número de tarjeta"); 
						  return "businessNotFound"; 
					  }
	}
	

@RequestMapping("/actualizarBusiness")
public String UpdateBusiness(@RequestParam("UpdateBusiness") String dni, Model model) {
	 Optional<Business> business = servicio.findById(dni);
	 
	  	if (business.isPresent()) {
	  		
	  	model.addAttribute("businessFromDB", business.get());
	    return "ActualizarBusiness";						
	  								}
	  	else
	  		{
	  								
	  			return "BusinessNotFound";
	  		}

}
	
}

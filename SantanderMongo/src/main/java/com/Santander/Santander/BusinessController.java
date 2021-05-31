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
		return "ListBusiness";
	}
	
	//Añade Tarjetas
	@RequestMapping("/addBusiness") public String addBusiness(Business business ,Model model) {
		  
		 servicio.save(business);
	 
	 return "redirect:/Santander/ListBusiness"; 
	 }
	
	
	@RequestMapping("/newBusiness") public String NewBusiness(Model model) {

		return "newBusiness"; }
	
	
	//Elimina Tarjetas

	@RequestMapping("/delBusiness")
	public String delBusiness(@RequestParam("delBusiness") String dni, Model model) {

		  Optional<Business> business = servicio.findById(dni);

		  if (business.isPresent()) {
			  servicio.deleteById(dni);
			  model.addAttribute("EtiquetaBD",servicio.findAll()); 
			  return  "deleteBusiness";
		  							}

		  			else { 
		  			return "BusinessNotFound";}
	}
	
	
	//Actualiza Tarjeta

	@PostMapping("/repBusiness{BusinessUpdate}") 
	public String Update(@PathVariable("BusinessUpdate") String dni ,Business business ,Model model) {

		  Optional<Business> Business = servicio.findById(dni);

	if (Business.isPresent()) {
				
				servicio.deleteById(dni);
				
				servicio.save(business);
			
				return "redirect:/Santander/BusinessUpdate";
								} 
					  else
					  { 
						  System.out.println("No encuentra el número de tarjeta"); 
						  return "BusinessNotFound"; 
					  }
	}
	

@RequestMapping("/updBusiness")
public String UpdateBusiness(@RequestParam("UpdateBusiness") String dni, Model model) {
	 Optional<Business> business = servicio.findById(dni);
	 
	  	if (business.isPresent()) {
	  		
	  	model.addAttribute("businessFromDB", business.get());
	    return "UpdateBusiness";						
	  								}
	  	else
	  		{
	  								
	  			return "BusinessNotFound";
	  		}

}
	
}

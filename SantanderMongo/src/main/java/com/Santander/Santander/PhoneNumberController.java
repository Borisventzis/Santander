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

public class PhoneNumberController {
	
@Autowired
PhoneNumberRepository servicio;

//Lista Móviles

@RequestMapping("/PhoneNumber")
public String ObtenerDatos(Model model) {
	model.addAttribute("EtiquetaBD",servicio.findAll());
	return "ListPhoneNumber";
}

//Añade Móviles
@RequestMapping("/addPhoneNumber") public String addPhoneNumber(PhoneNumber phonenumber ,Model model) {
	  
	 servicio.save(phonenumber);
 
 return "redirect:/Santander/ListPhoneNumber"; 
 }


@RequestMapping("/newPhoneNumber") public String NewPhoneNumber(Model model) {

return "newPhoneNumber"; }


//Elimina Móviles

@RequestMapping("/delPhoneNumber")
public String delPhoneNumber(@RequestParam("delPhoneNumber") String dni, Model model) {

	  Optional<PhoneNumber> phonenumber = servicio.findById(dni);

	  if (phonenumber.isPresent()) {
		  servicio.deleteById(dni);
		  model.addAttribute("EtiquetaBD",servicio.findAll()); 
		  return  "deletePhoneNumber";
	  							}

	  			else { 
	  			return "PhoneNumberNotFound";}
}


//Actualiza Número de Móvil

@PostMapping("/repPhoneNumber/{PhoneNumberUpdate}") 
public String Update(@PathVariable("PhoneNumberUpdate") String dni ,PhoneNumber phonenumber ,Model model) {

	  Optional<PhoneNumber> phoneNumber = servicio.findById(dni);

if (phoneNumber.isPresent()) {
			
			servicio.deleteById(dni);
			
			servicio.save(phonenumber);
		
			return "redirect:/Santander/NumberUpdate";
							} 
				  else
				  { 
					  System.out.println("No encuentra el número de móvil"); 
					  return "PhoneNumberNotFound"; 
				  }
}

@RequestMapping("/updPhoneNumber")
public String UpdatePhoneNumber(@RequestParam("UpdatePhoneNumber") String dni, Model model) {
	 Optional<PhoneNumber> phonenumber = servicio.findById(dni);
	 
	  	if (phonenumber.isPresent()) {
	  		
	  	model.addAttribute("phonenumberFromDB", phonenumber.get());
	    return "UpdatePhoneNumber";						
	  								}
	  	else
	  		{
	  								
	  			return "PhoneNumberNotFound";
	  		}

																							}


}

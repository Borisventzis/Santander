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
	return "PhoneNumber";
}

//Añade Móviles
@RequestMapping("/newPhoneNumber") public String newPhoneNumber(PhoneNumber phonenumber ,Model model) {
	  
	 servicio.save(phonenumber);
 
 return "redirect:/Santander/PhoneNumber"; 
 }


@RequestMapping("/nuevoPhoneNumber") public String NuevoPhoneNumber(Model model) {

return "nuevophonenumber"; }


//Elimina Móviles

@RequestMapping("/eliminarPhoneNumber")
public String EliminarPhoneNumber(@RequestParam("PhoneNumberEliminar") String dni, Model model) {

	  Optional<PhoneNumber> phonenumber = servicio.findById(dni);

	  if (phonenumber.isPresent()) {
		  servicio.deleteById(dni);
		  model.addAttribute("EtiquetaBD",servicio.findAll()); 
		  return  "DeletePhoneNumber";
	  							}

	  			else { 
	  			return "PhoneNumberNotFound";}
}


//Actualiza Número de Móvil

@PostMapping("/reemplazarPhoneNumber/{PhoneNumberActualizar}") 
public String Update(@PathVariable("PhoneNumberActualizar") String dni ,PhoneNumber phonenumber ,Model model) {

	  Optional<PhoneNumber> phoneNumber = servicio.findById(dni);

if (phoneNumber.isPresent()) {
			
			servicio.deleteById(dni);
			
			servicio.save(phonenumber);
		
			return "redirect:/Santander/PhoneNumber";
							} 
				  else
				  { 
					  System.out.println("No encuentra el número de móvil"); 
					  return "PhoneNumberNotFound"; 
				  }
}

@RequestMapping("/actualizarPhoneNumber")
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

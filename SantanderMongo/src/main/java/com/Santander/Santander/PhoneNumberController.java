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
	
//Lista números de móvil 

@RequestMapping("/PhoneNumber")
public String obtenerDatos(Model model) {
	model.addAttribute("EtiquetaBD", servicio.findAll());
	return "PhoneNumber";
	
}

//Añade número de móvil
@RequestMapping("/addPhoneNumber") 
public String addPhoneNumber(PhoneNumber phonenumber, Model model) {
	phonenumber.setCellPhone(phonenumber.getCellPhone());
	phonenumber.setDNI(phonenumber.getDNI()+1);
	servicio.save(phonenumber);
	return "redirect:/Santander/PhoneNumber";
}

@RequestMapping("/newPhoneNumber") 
public String newPhoneNumber(PhoneNumber phonenumber, Model model) {
	return "NewPhoneNumber";
	
}


//Eliminar número de móvil

@RequestMapping("delPhoneNumber")
public String deletePhoneNumber(@RequestParam("DeletePhoneNumber") String dni, Model model) {
	
	Optional<PhoneNumber> PhoneNumber = servicio.findById(dni);
	
	if (PhoneNumber.isPresent()) {
		servicio.deleteById(dni);
		model.addAttribute("EtiquetaBD", servicio.findAll());
		return "DeletePhoneNumber";
				
	}
	
	else {
		return "UserNotFound";
	}
	
}

//Actualizar número de móvil

@PostMapping("replacePhoneNumber/{PhoneNumber}")
public String Update(@PathVariable("PhoneNumber") String dni, PhoneNumber phonenumber, Model model) {
	
	Optional<PhoneNumber> PhoneNumber = servicio.findById(dni);
	
	if (PhoneNumber.isPresent()) {
		//System.out.println("Encuentra el número del Móvil"); 
		servicio.deleteById(dni);
		phonenumber.setCellPhone(phonenumber.getCellPhone());
		servicio.save(phonenumber);
		System.out.println("Lo agrega a la bd"); 
		return "redirect:/Santander/PhoneNumber";
	}
	
	else {
		//System.out.println("No encuentra el número del Móvil");
		return "UserNotFound"; 
	}
	
}


@RequestMapping("/updatePhoneNumber")
public String UpdatePhoneNumber(@RequestParam("UpdatePhoneNumber") String dni, Model model) { 
	Optional<PhoneNumber> PhoneNumber = servicio.findById(dni);
	
	if (PhoneNumber.isPresent()) { 
		model.addAttribute("PhoneNumberFromDB", PhoneNumber.get());
	    return "UpdatePhoneNumber";	
			
	}
	
	else {
		return "UserNotFound";
	}
}


}

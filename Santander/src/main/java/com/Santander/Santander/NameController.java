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
public class NameController {

	@Autowired
	NameRepository servicio;
	//SanService servicio;
	@RequestMapping("/Usuarios")
	public String ObtenerDatos(Model model) {
		model.addAttribute("EtiquetaBD",servicio.findAll());
		return "Usuarios";
	}
	
	 @RequestMapping("/newuser") public String newuser(Name name ,Model
			  model) {
			  name.setUsername(name.getFirstName()+"."+name.getLastName());
			  name.setDNI(name.getDNI()+1);
				 servicio.save(name);
			  
			  return "redirect:/Santander/Usuarios"; 
			  }
	
	  @RequestMapping("/nuevoUsuario") public String NuevoUsuario(Model model) {
	  
		 // servicio.save(name);
	  
	  return "nuevousuario"; }
	
	  
	  @RequestMapping("/eliminarUsuario")
	  public String EliminarUsuario(@RequestParam("UsuarioEliminar") long dni, Model model) {
	
		  Optional<Name> Usuario = servicio.findById(dni);

		  if (Usuario.isPresent()) {
			  servicio.deleteById(dni);
			  model.addAttribute("EtiquetaBD",servicio.findAll()); 
			  return  "DeletedUser";
		  							}
	  
		  			else { 
		  			return "UserNotFound";
		  					}
		  
	  }
	  
	  @PostMapping("/reemplazarUsuario/{UsuarioActualizar}") 
	  public String Update(@PathVariable("UsuarioActualizar") long dni ,Name name ,Model model) {
	
		  Optional<Name> Usuario = servicio.findById(dni);
	  
	  if (Usuario.isPresent()) {
			
				servicio.deleteById(dni);
				name.setUsername(name.getFirstName()+"."+name.getLastName());
				servicio.save(name);
				
				return "redirect:/Santander/Usuarios";
	  							} 
					  else
					  { 
						  System.out.println("No encuentra el campeon"); 
						  return "UserNotFound"; 
					  }
	  }
	  
	  @RequestMapping("/actualizar")
	  public String UpdateChamp(@RequestParam("UsuarioActualizar") long dni, Model model) {
		 Optional<Name> Usuario = servicio.findById(dni);
		 
		  	if (Usuario.isPresent()) {
		  		
		  	model.addAttribute("UserFromDB", Usuario.get());
		    return "ActualizarUsuario";						
		  								}
		  	else
		  		{
		  								
		  			return "UserNotFound";
		  		}
	
	  																							}																		
	 
	
	}


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
public class JobController {

	@Autowired
	JobRepository servicio;
	@RequestMapping("Jobs")
	public String ObtenerDatos(Model model) {
		model.addAttribute("EtiquetaBD",servicio.findAll());
		return "Usuarios";
	}
	
	 @RequestMapping("/newJob") public String newJob(Job job ,Model model) {
		  
		 servicio.save(job);
	  
	  return "redirect:/Santander/Job"; 
	  }

	 @RequestMapping("/nuevoJob") public String NuevoJob(Model model) {

		 return "nuevojob"; }
	
	 
	  @RequestMapping("/eliminarJob")
	  public String EliminarJob(@RequestParam("JobEliminar") String dni, Model model) {
	
		  Optional<Job> job = servicio.findById(dni);

		  if (job.isPresent()) {
			  servicio.deleteById(dni);
			  model.addAttribute("EtiquetaBD",servicio.findAll()); 
			  return  "DeletedJob";
		  							}
	  
		  			else { 
		  			return "JobNotFound";
		  					}
		  
	  }
	  
	  @PostMapping("/reemplazarJob/{JobActualizar}") 
	  public String Update(@PathVariable("JobActualizar") String dni ,Job job ,Model model) {
	
		  Optional<Job> empleo = servicio.findById(dni);
	  
	  if (empleo.isPresent()) {
				
				servicio.deleteById(dni);
				
				servicio.save(job);
			
				return "redirect:/Santander/Address";
	  							} 
					  else
					  { 
						  System.out.println("No encuentra la direccion"); 
						  return "addressNotFound"; 
					  }
	  }
	  
	 
}

package com.Santander.Santander;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/webapi")
public class JobRestController {
	
	@Autowired
	JobRepository servicio;
	
	@GetMapping("/Job")
	public Iterable<Job>ObtenerDatos() {
		
		return servicio.findAll();
		
	}
	
	@PostMapping(path="/nuevoJob", consumes="application/json")
	void NuevoJob(@RequestBody Job job) {
		
		servicio.save(job);
	}
	
	
	@DeleteMapping("/eliminarJob/{DNI}")	
	public void DeleteJob(@PathVariable String DNI) {
			if (servicio.findById(DNI) != null) {
				servicio.deleteById(DNI);
				
			}
			
	}
	
	@PutMapping("/actualizarJob/{dni}")
	public Optional<Job> updateJob(@RequestBody Job job, @PathVariable String dni) {
		Optional<Job> Job = servicio.findById(dni);

		if (Job.isPresent()) {

			Job.get().setDNI(job.getDNI());
			Job.get().setKeySkills(job.getKeySkills());
			Job.get().setPosition(job.getPosition());
			Job.get().setSeniority(job.getSeniority());
			Job.get().setTitle(job.getSeniority());

			servicio.save(Job.get());
			return Job;
		} else {
		
		return Job;}
	}
	
}

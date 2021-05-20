package com.Santander.Santander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Santander")
public class SanController {

	@Autowired
	NameRepository servicio;
	//SanService servicio;
	@RequestMapping("/Usuarios")
	public String ObtenerDatos(Model model) {
		model.addAttribute("EtiquetaBD",servicio.findAll());
		return "Usuarios";
	}
	
	
	/*
	 * @RequestMapping("/newChamp") public String NuevoCampeon(Champs champ ,Model
	 * model) {
	 * 
	 * //servicio.nuevocampeon(champ);
	 * 
	 * return "nuevocampeon"; }
	 * 
	 * @RequestMapping("/Champions") public String AñadirCampeon(Model model,Champs
	 * champ){ // servicio.nuevocampeon(champ);
	 * model.addAttribute("EtiquetaBD",servicio.findAll()); return "Champions";
	 * 
	 * }
	 * 
	 * @RequestMapping("/DeleteChamp")
	 * 
	 * public String EliminarCampeon(@RequestParam("CampeonEliminar") String name,
	 * Model model) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if (servicio.findChampByName(name) == -1) {
	 * 
	 * return "ChampNotFound"; } else { servicio.DeleteChamp(name);
	 * model.addAttribute("EtiquetaBD",servicio.ShowAll()); return
	 * "DeletedChampion"; }
	 * 
	 * }
	 * 
	 * @PostMapping("/Update/{ChampActualizar}") public String
	 * Update(@PathVariable("ChampActualizar") String name ,Champs champ ,Model
	 * model) { System.out.println("Llego hasta el Update");
	 * 
	 * int index = servicio.findChampByName(name); if (index == -1) {
	 * System.out.println("No encuentra el campeon"); return "ChampNotFound"; } else
	 * { System.out.println("Encuentra el campeon"); servicio.updateChamp(champ,
	 * index); System.out.println("Lo agrega a la bd"); return
	 * "redirect:/League/Champs"; }
	 * 
	 * 
	 * }
	 * 
	 * @RequestMapping("/UpdateChamp") public String
	 * UpdateChamp(@RequestParam("CampeonActualizar") String name, Model model) {
	 * 
	 * int index = servicio.findChampByName(name); if (index == -1) {
	 * 
	 * return "ChampNotFound"; } else { Champs champ =
	 * servicio.findObjChampByName(name); model.addAttribute("ChampFromDB", champ);
	 * 
	 * return "ActualizarCampeon"; }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	}


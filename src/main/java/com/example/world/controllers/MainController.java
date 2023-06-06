package com.example.world.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.world.services.APIService;

@Controller
public class MainController {
	@Autowired
	private APIService apiService;
//	@Autowired
//	private PaisRepo paisRepo;
	
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		List<Object[]> paisesHablaSloveno = apiService.paisesHablaSloveno();
		List<Object[]> ciudadesBuenosAiresPoblacion = apiService.ciudadesBuenosAiresPoblacion();
		
//		int id = 240;
//		apiService.deleteUnPais(id);
		
//		List<Object[]> paisesHablaSloveno = paisRepo.paisesHablaSloveno();
//		List<Object[]> insertarPais = apiService.insertarPais();
		
		viewModel.addAttribute("paisesHablaSloveno", paisesHablaSloveno);
		viewModel.addAttribute("ciudadesBuenosAiresPoblacion", ciudadesBuenosAiresPoblacion);
		
		return "index.jsp";
	}
	

}

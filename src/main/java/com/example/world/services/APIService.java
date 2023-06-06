package com.example.world.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.world.repositories.PaisRepo;

@Service
public class APIService {
	@Autowired
	private PaisRepo paisRepo;
	
//	public List<Object[]> insertarPais(){
//		return paisRepo.insertarPais();
//	}
	
	public List<Object[]> paisesHablaSloveno(){
		return paisRepo.paisesHablaSloveno();
	}

	public List<Object[]> ciudadesBuenosAiresPoblacion(){
		return paisRepo.ciudadesBuenosAiresPoblacion();
	}
	
	public int deleteUnPais(int id) {
		return paisRepo.deleteUnPais(id);
	}
	
}

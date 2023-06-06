package com.example.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.world.models.PaisModel;

//import com.example.world.models.PaisModel;


public interface PaisRepo extends CrudRepository<PaisModel, Long>{
	
	// Consulta 1Todos los países que hablan Sloveno? Su consulta debe retornar el nombre del país, lenguaje y porcentaje del lenguaje. Su consulta debe organizar los resultados por porcentaje en orden descendente.
	@Query(value="SELECT name, language, percentage FROM countries JOIN languages "
			+ "ON countries.id = languages.country_id"
			+ " WHERE language = 'Slovene' ORDER BY percentage DESC;", nativeQuery=true)
	List<Object[]> paisesHablaSloveno();
	
	
	// Consulta 7. ¿Qué consulta ejecutarías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires y que tengan una población mayor a 500.000? La consulta debe retornar el nombre del país, nombre de la ciudad, distrito y población.
	@Query(value="SELECT  countries.name, cities.name, cities.district, cities.population FROM countries\r\n"
			+ "INNER JOIN cities ON countries.id = cities.country_id\r\n"
			+ "WHERE countries.name =\"Argentina\" AND district =\"Buenos Aires\" AND cities.population > 500000\r\n"
			+ "ORDER BY cities.population DESC;", nativeQuery=true)
	
	List<Object[]> ciudadesBuenosAiresPoblacion();
	
//	@Modifying
//	@Query(value="INSERT INTO countries (code, name, continent, region) VALUES ('YEM', 'Test1', 'Asia', 'Test1');", nativeQuery=true) 
//	List<Object[]> insertarPais();
//	
	
	@Modifying
    @Query(value="delete PaisModel c WHERE c.id = ?1", nativeQuery=true)
    int deleteUnPais(int id);
	
	

	
}

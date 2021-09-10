package com.inventario.app.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.app.entity.Taza;
import com.inventario.app.service.TazaService;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/inventario/taza")
public class TazaController {
	
	@Autowired
	private TazaService tazaService;
	
	
	//Create new cup
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Taza taza){
		return ResponseEntity.status(HttpStatus.CREATED).body(tazaService.save(taza));
	}
	
	//read cup
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<Taza> oTaza = tazaService.findById(id);
		if(!oTaza.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oTaza);
	}
	
	@GetMapping("")
	public List<Taza> readAll (){
		List<Taza> tazas = StreamSupport
				.stream(tazaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return tazas;
	}
	
}


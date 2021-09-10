package com.inventario.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inventario.app.entity.Taza;

public interface TazaService {

	
public Iterable<Taza> findAll();
	
	public Page<Taza> findAll(Pageable pageable);
	
	public Optional<Taza> findById(Long id);
	
	public Taza save(Taza taza);
	
	public void deleteById(Long id);
	
	
	public static Result show(Long id) {
		Taza taza = Taza.findByTazaId(id);
		  return taza;
		}
}
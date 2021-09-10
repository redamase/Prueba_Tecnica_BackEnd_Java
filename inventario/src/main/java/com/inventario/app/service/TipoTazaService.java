package com.inventario.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inventario.app.entity.TipoTaza;

public interface TipoTazaService {

	
public Iterable<TipoTaza> findAll();
	
	public Page<TipoTaza> findAll(Pageable pageable);
	
	public Optional<TipoTaza> findById(Long id);
	
	public TipoTaza save(TipoTaza tipoTaza);
	
	public void deleteById(Long id);
}


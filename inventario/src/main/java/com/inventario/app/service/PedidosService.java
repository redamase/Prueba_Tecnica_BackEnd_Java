package com.inventario.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inventario.app.entity.Pedidos;

public interface PedidosService {

	
public Iterable<Pedidos> findAll();
	
	public Page<Pedidos> findAll(Pageable pageable);
	
	public Optional<Pedidos> findById(Long id);
	
	public Pedidos save(Pedidos pedidos);
	
	public void deleteById(Long id);
	
}

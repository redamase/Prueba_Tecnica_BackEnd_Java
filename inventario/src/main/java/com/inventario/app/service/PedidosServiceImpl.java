package com.inventario.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.app.entity.Pedidos;
import com.inventario.app.repository.PedidosRepository;

@Service
public class PedidosServiceImpl implements PedidosService{

	@Autowired
	
	private PedidosRepository pedidosRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pedidos> findAll() {
		return pedidosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pedidos> findAll(Pageable pageable) {
		return pedidosRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedidos> findById(Long id) {
		return pedidosRepository.findById(id);
	}

	@Override
	@Transactional
	public Pedidos save(Pedidos pedidos) {
		return pedidosRepository.save(pedidos);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		pedidosRepository.deleteById(id);
	}	

}
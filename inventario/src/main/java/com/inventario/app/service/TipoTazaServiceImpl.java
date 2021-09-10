package com.inventario.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.inventario.app.entity.TipoTaza;
import com.inventario.app.repository.TipoTazaRepository;

@Service
public class TipoTazaServiceImpl implements TipoTazaService{

	@Autowired
	
	private TipoTazaRepository tipoTazaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoTaza> findAll() {
		return tipoTazaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoTaza> findAll(Pageable pageable) {
		return tipoTazaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoTaza> findById(Long id) {
		return tipoTazaRepository.findById(id);
	}

	@Override
	@Transactional
	public TipoTaza save(TipoTaza tipoTaza) {
		return tipoTazaRepository.save(tipoTaza);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tipoTazaRepository.deleteById(id);
	}	

}
package com.inventario.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.app.entity.Taza;

@Repository
public interface TazaRepository extends JpaRepository<Taza, Long>{

}

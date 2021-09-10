package com.inventario.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.app.entity.TipoTaza;

@Repository
public interface TipoTazaRepository extends JpaRepository<TipoTaza, Long>{

}

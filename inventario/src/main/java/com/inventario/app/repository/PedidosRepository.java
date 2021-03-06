package com.inventario.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.inventario.app.entity.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{
	
}

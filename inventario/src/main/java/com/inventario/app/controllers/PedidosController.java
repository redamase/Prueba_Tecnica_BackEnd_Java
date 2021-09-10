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

import com.inventario.app.entity.Pedidos;
import com.inventario.app.service.PedidosService;

import com.inventario.app.entity.Taza;
import com.inventario.app.service.TazaService;


@CrossOrigin
@RestController
@RequestMapping(path = "/api/inventario/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidosService pedidosService;
	private TazaService tazaService;
	
	//Create new order
	@PostMapping

	public  ResponseEntity<?> create (@RequestBody Pedidos pedidos){
		if(pedidos.getCantidad_total() >=10 && pedidos.getTipo_taza().equals("Calidad Alta")) {
			pedidos.setCantidad_regalo(3);
			pedidos.setTipo_taza_regalo("Calidad Baja");
			Optional<Taza> taza = tazaService.findById(pedidos.getId_taza());
			Taza.setCantidad_disponible(Taza.getCantidad_disponible - 2)
		}
		else if(pedidos.getCantidad_total() >=10 && pedidos.getTipo_taza().equals("Calidad Baja")) {
			pedidos.setCantidad_regalo(2);
			pedidos.setTipo_taza_regalo("Calidad Baja");
		}
		else if(pedidos.getCantidad_total() < 10 ) {
			pedidos.setCantidad_regalo(0);
			pedidos.setTipo_taza_regalo("");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidosService.save(pedidos));
		//return ResponseEntity.status(HttpStatus.CREATED).body(pedidosService.save(pedidos));
	}
	
	
	//read order
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id){
		Optional<Pedidos> oPedidos = pedidosService.findById(id);
		if(!oPedidos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPedidos);
	}
	
	@GetMapping("")
	public List<Pedidos> readAll (){
		List<Pedidos> pedidos = StreamSupport
				.stream(pedidosService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return pedidos;
	}
	
}

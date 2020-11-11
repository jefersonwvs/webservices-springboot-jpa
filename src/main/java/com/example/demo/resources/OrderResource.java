 package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;

@RestController /* anotação para o spring identificar que a classe se trata de um recurso Rest */
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired /* faz injeção de dependência automaticamente */
	private OrderService service;
	
	@GetMapping /* anotação de método get */
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") /* anotação de método get com argumento */
	public ResponseEntity<Order> findById(@PathVariable Long id) { /* anotação que indica onde usar o argumento */
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
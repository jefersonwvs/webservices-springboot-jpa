package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController /* anotação para o spring identificar que a classe se trata de um recurso Rest */
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired /* faz injeção de dependência automaticamente */
	private ProductService service;
	
	@GetMapping /* anotação de método get */
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") /* anotação de método get com argumento */
	public ResponseEntity<Product> findById(@PathVariable Long id) { /* anotação que indica onde usar o argumento */
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
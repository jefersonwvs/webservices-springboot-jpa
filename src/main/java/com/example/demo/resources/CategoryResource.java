package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController /* anotação para o spring identificar que a classe se trata de um recurso Rest */
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired /* faz injeção de dependência automaticamente */
	private CategoryService service;
	
	@GetMapping /* anotação de método get */
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") /* anotação de método get com argumento */
	public ResponseEntity<Category> findById(@PathVariable Long id) { /* anotação que indica onde usar o argumento */
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
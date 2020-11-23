package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController /* anotação para o spring identificar que a classe se trata de um controlador Rest */
@RequestMapping(value = "/users") /* caminho para acessar o recurso */
public class UserResource {
	
	@Autowired /* faz injeção de dependência automaticamente */
	private UserService service;
	
	@GetMapping /* anotação de método get */
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") /* caminho para chamar um get com argumentos */
	public ResponseEntity<User> findById(@PathVariable /* anotação que indica onde usar o argumento */
										 Long id) 
	{
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping /* anotação de método de postagem (inserção de objeto) */
	public ResponseEntity<User> insert(@RequestBody /* indica que o novo objeto virá no formato JSON*/ 
										User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest(). /* Elemento criado para fazer inserções da forma correta */
				path("/{id}").
				buildAndExpand(obj.getId()).
				toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
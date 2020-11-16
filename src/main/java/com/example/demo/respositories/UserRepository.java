package com.example.demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

/* Classe responsável por acessar os dados no BD.
 * Implementa os padrões de injeção de dependência.
 * */
@Repository /* registra a classe como repositório, para que o Spring faça a injeção de dependência.
No entanto, diferente de um service, a anotação aqui é opcional, pois sua superclasse já está registrada */
public interface UserRepository extends JpaRepository<User, Long>{

}

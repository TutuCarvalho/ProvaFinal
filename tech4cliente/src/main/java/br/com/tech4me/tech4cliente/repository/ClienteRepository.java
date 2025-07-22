package br.com.tech4me.tech4cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4cliente.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

}

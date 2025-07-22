package br.com.tech4me.tech4agenda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4agenda.model.Agendamento;

public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {

}

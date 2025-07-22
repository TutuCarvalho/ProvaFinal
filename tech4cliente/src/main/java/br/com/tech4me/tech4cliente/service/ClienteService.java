package br.com.tech4me.tech4cliente.service;

import java.util.List;
import br.com.tech4me.tech4cliente.shared.ClienteCompletoDTO;
import br.com.tech4me.tech4cliente.shared.ClienteDTO;

public interface ClienteService {
    List<ClienteDTO> ObterTodos();
    ClienteCompletoDTO ObterPorId(String id);
    ClienteCompletoDTO Cadastrar(ClienteCompletoDTO cliente);
    ClienteCompletoDTO Atualizar(String id, ClienteCompletoDTO cliente);
    void Remover(String id);
}

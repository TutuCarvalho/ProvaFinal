package br.com.tech4me.tech4agenda.service;

import java.util.List;
import br.com.tech4me.tech4agenda.shared.AgendamentoCompletoDTO;
import br.com.tech4me.tech4agenda.shared.AgendamentoDTO;

public interface AgendamentoService {
    
    List<AgendamentoCompletoDTO> obterTodos();
    AgendamentoDTO obterPorId(String id);
    AgendamentoCompletoDTO cadastrar(AgendamentoCompletoDTO agendamento);
    AgendamentoDTO atualizar(String id, AgendamentoDTO agendamento);
    void excluir(String id);
    
}

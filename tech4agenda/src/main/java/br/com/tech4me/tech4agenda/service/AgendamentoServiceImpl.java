package br.com.tech4me.tech4agenda.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.tech4agenda.httpClient.ClienteClient;
import br.com.tech4me.tech4agenda.model.Agendamento;
import br.com.tech4me.tech4agenda.model.Cliente;
import br.com.tech4me.tech4agenda.repository.AgendamentoRepository;
import br.com.tech4me.tech4agenda.shared.AgendamentoCompletoDTO;
import br.com.tech4me.tech4agenda.shared.AgendamentoDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private ClienteClient clienteClient;
    
    @Override
    public List<AgendamentoCompletoDTO> obterTodos() {
        return repository.findAll()
            .stream()
            .map(a -> new AgendamentoCompletoDTO(a.getId(), a.getIdCliente(), a.getServico(), a.getDataHora()))
            .toList();        
    }

    @CircuitBreaker(name = "obterCliente", fallbackMethod = "fallbackObterPorId")
    @Override
    public AgendamentoDTO obterPorId(String id) {
        Agendamento agendamento = repository.findById(id).orElse(null);

        if (agendamento != null) {
            Cliente cliente = clienteClient.obterCliente(agendamento.getIdCliente());
            return new AgendamentoDTO(agendamento.getIdCliente(),
                cliente,
                agendamento.getServico(),
                agendamento.getDataHora());
        }
        return null;
    }
    
    public AgendamentoDTO fallbackObterPorId(String id, Exception e) {
        Agendamento agendamento = repository.findById(id).orElse(null);

        if (agendamento != null) {
            return new AgendamentoDTO(agendamento.getIdCliente(), null, agendamento.getServico(), agendamento.getDataHora());
        }

        return null;
    }

    @Override
    public AgendamentoCompletoDTO cadastrar(AgendamentoCompletoDTO dto) {
        Agendamento agendamento = new Agendamento(dto);
        repository.save(agendamento);
        return new AgendamentoCompletoDTO(agendamento.getId(), 
            agendamento.getIdCliente(),
            agendamento.getServico(),
            agendamento.getDataHora());
    }

    @Override
    public AgendamentoDTO atualizar(String id, AgendamentoDTO dto) {
        Agendamento agendamentoAtualizado = repository.findById(id).orElse(null);

        if (agendamentoAtualizado != null) {
            agendamentoAtualizado.setIdCliente(dto.idCliente());
            agendamentoAtualizado.setServico(dto.servico());
            agendamentoAtualizado.setDataHora(dto.dataHora());
            repository.save(agendamentoAtualizado);
            return new AgendamentoDTO(agendamentoAtualizado.getIdCliente(),
                null,
                agendamentoAtualizado.getServico(),
                agendamentoAtualizado.getDataHora());
        }
        
        return null;
    }

    @Override
    public void excluir(String id) {
        repository.deleteById(id);
    }

}

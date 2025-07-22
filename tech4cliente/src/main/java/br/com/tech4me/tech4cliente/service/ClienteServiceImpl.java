package br.com.tech4me.tech4cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.tech4cliente.model.Cliente;
import br.com.tech4me.tech4cliente.repository.ClienteRepository;
import br.com.tech4me.tech4cliente.shared.ClienteCompletoDTO;
import br.com.tech4me.tech4cliente.shared.ClienteDTO;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository; 

    @Override
    public List<ClienteDTO> ObterTodos() {
        return repository.findAll()
            .stream()
            .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getEmail()))
            .toList();
    }

    @Override
    public ClienteCompletoDTO ObterPorId(String id) {
        Cliente cliente = repository.findById(id).orElse(null);

        if (cliente != null) {
            return new ClienteCompletoDTO(cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getNumeroCelular(),
                cliente.getEndereco());
        } else {
            return null;
        }
    }

    @Override
    public ClienteCompletoDTO Cadastrar(ClienteCompletoDTO cliente) {
        
        Cliente clienteCadastro = new Cliente(cliente);
        repository.save(clienteCadastro);

        return new ClienteCompletoDTO(clienteCadastro.getId(),
            clienteCadastro.getNome(),
            clienteCadastro.getEmail(),
            clienteCadastro.getNumeroCelular(),
            clienteCadastro.getEndereco());
    }

    @Override
    public ClienteCompletoDTO Atualizar(String id, ClienteCompletoDTO cliente) {
        
        Cliente clienteLocalizado = repository.findById(id).orElse(null);
        
        if (clienteLocalizado != null) {
            
            Cliente clienteAtualizado = new Cliente(cliente);
            clienteAtualizado.setId(id);
            repository.save(clienteAtualizado);

            return new ClienteCompletoDTO(clienteAtualizado.getId(),
                clienteAtualizado.getNome(),
                clienteAtualizado.getEmail(),
                clienteAtualizado.getNumeroCelular(),
                clienteAtualizado.getEndereco());
        
        } else {
            return null;
        }
    }

    @Override
    public void Remover(String id) {
        repository.deleteById(id);
    }

}

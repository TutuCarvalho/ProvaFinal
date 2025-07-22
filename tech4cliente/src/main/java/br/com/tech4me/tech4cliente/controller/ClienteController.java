package br.com.tech4me.tech4cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.tech4cliente.service.ClienteService;
import br.com.tech4me.tech4cliente.shared.ClienteCompletoDTO;
import br.com.tech4me.tech4cliente.shared.ClienteDTO;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> ObterTodos(){
        return new ResponseEntity<>(service.ObterTodos(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ClienteCompletoDTO> ObterPorId(@PathVariable String id){
        ClienteCompletoDTO cliente = service.ObterPorId(id);

        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteCompletoDTO> Cadastrar(@RequestBody ClienteCompletoDTO cliente){
        return new ResponseEntity<>(service.Cadastrar(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteCompletoDTO> Atualizar(@PathVariable String id, @RequestBody @Validated ClienteCompletoDTO cliente){
        ClienteCompletoDTO clienteAtualizado = service.Atualizar(id, cliente);

        if (clienteAtualizado != null) {
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Remover(@PathVariable String id){
        service.Remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

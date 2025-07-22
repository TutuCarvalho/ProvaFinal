package br.com.tech4me.tech4agenda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.tech4agenda.service.AgendamentoService;
import br.com.tech4me.tech4agenda.shared.AgendamentoCompletoDTO;
import br.com.tech4me.tech4agenda.shared.AgendamentoDTO;

@RestController
@RequestMapping("/agenda")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping()
    public ResponseEntity<List<AgendamentoCompletoDTO>> obterTodos(){
        return new ResponseEntity<>(service.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> obterPorId(@PathVariable String id){
        AgendamentoDTO agendamento = service.obterPorId(id);

        if (agendamento != null) {
            return new ResponseEntity<>(agendamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    public ResponseEntity<AgendamentoCompletoDTO> cadastrar(@RequestBody AgendamentoCompletoDTO dto){
        return new ResponseEntity<>(service.cadastrar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> atualizar(@PathVariable String id, @RequestBody AgendamentoDTO dto){
        AgendamentoDTO agendamentoAtualizado = service.atualizar(id, dto);

        if (agendamentoAtualizado != null) {
            return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> excluir(@PathVariable String id){
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

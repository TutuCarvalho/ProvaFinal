package br.com.tech4me.tech4agenda.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4agenda.shared.AgendamentoCompletoDTO;

@Document("agendamentos")
public class Agendamento {

    @Id
    private String id;
    private String idCliente;
    private String servico;
    private LocalDateTime dataHora;

    public Agendamento(){}

    public Agendamento(AgendamentoCompletoDTO dto){
        id = dto.id();
        idCliente = dto.idCliente();
        servico = dto.servico();
        dataHora = dto.dataHora();
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}

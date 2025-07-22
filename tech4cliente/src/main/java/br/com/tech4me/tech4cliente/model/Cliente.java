package br.com.tech4me.tech4cliente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.tech4cliente.shared.ClienteCompletoDTO;

@Document("vendas")
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String email;
    private String numeroCelular;
    private String endereco;
    
    public Cliente(){}

    public Cliente(ClienteCompletoDTO cliente){
        id = cliente.id();
        nome = cliente.nome();
        email = cliente.email();
        numeroCelular = cliente.numeroCelular();
        endereco = cliente.endereco();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}

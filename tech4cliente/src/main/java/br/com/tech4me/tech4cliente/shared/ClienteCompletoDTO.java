package br.com.tech4me.tech4cliente.shared;

public record ClienteCompletoDTO(String id,
    String nome,
    String email,
    String numeroCelular,
    String endereco) {
}

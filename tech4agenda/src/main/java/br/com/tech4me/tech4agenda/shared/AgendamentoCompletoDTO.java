package br.com.tech4me.tech4agenda.shared;

import java.time.LocalDateTime;

public record AgendamentoCompletoDTO(String id,
    String idCliente,
    String servico,
    LocalDateTime dataHora) {
}

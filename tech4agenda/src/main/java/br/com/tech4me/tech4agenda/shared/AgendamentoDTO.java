package br.com.tech4me.tech4agenda.shared;

import java.time.LocalDateTime;
import br.com.tech4me.tech4agenda.model.Cliente;

public record AgendamentoDTO(String idCliente,
    Cliente cliente,
    String servico,
    LocalDateTime dataHora) {
}

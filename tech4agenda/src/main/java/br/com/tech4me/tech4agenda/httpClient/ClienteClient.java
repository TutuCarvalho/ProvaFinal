package br.com.tech4me.tech4agenda.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.tech4agenda.model.Cliente;

@FeignClient("cliente")
public interface ClienteClient {

    @RequestMapping(method = RequestMethod.GET, value = "cliente/{id}")
    Cliente obterCliente(@PathVariable String id);

}

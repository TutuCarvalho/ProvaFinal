package br.com.tech4me.tech4agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class Tech4agendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tech4agendaApplication.class, args);
	}

}

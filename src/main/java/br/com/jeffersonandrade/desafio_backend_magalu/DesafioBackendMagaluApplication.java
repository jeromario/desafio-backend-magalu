package br.com.jeffersonandrade.desafio_backend_magalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DesafioBackendMagaluApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackendMagaluApplication.class, args);
	}

}

package br.net.mirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.net.mirante.*", "br.net.mirante.controllers", "br.net.mirante.security", "br.net.mirante"})
public class DesafioMiranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioMiranteApplication.class, args);
	}

}

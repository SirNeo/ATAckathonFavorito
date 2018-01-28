package es.jmpalma.atackathon.favorito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"es.jmpalma.atackathon"})
public class MicroservicioFavoritoApplication {

	public static final Logger log = LoggerFactory.getLogger(MicroservicioFavoritoApplication.class.getName());
	
	public static void main(String[] args) {
		log.debug("MicroservicioFavoritoApplication :: main :: inicio");
		SpringApplication.run(MicroservicioFavoritoApplication.class, args);
	}
}

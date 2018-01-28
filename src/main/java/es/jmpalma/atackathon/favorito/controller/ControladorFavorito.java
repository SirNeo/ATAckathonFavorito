package es.jmpalma.atackathon.favorito.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.jmpalma.atackathon.favorito.dto.Libro;
import es.jmpalma.atackathon.favorito.service.ServicioFavorito;

@EnableCircuitBreaker //Habilita Hytrix
@RestController
@RequestMapping(value="/favoritos/api")
public class ControladorFavorito {

	public static final Logger log = LoggerFactory.getLogger(ControladorFavorito.class.getName());
	
	//http://localhost:8090/h2-console/
	
	@Autowired
	private ServicioFavorito servicio;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public List<Libro> obtenerListaFavoritos() {
		log.debug("obtenerListaFavoritos()");
		return servicio.obtenerListaFavoritos();
	}
}

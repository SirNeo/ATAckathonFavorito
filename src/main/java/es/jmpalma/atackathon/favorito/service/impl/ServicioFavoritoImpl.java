package es.jmpalma.atackathon.favorito.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.jmpalma.atackathon.favorito.dto.Libro;
import es.jmpalma.atackathon.favorito.service.ServicioFavorito;

@Service
public class ServicioFavoritoImpl implements ServicioFavorito {

	public static final Logger log = LoggerFactory.getLogger(ServicioFavoritoImpl.class.getName());
	
	private RestTemplate restTemplate;
	
	@Value("${servicio.catalogo.favoritos.url}")
	private String catalogoUri;
	
	@HystrixCommand(fallbackMethod = "callbackFailure")
	public List<Libro> obtenerListaFavoritos() {
		log.debug("obtenerListaFavoritos()");
	  
		URI uri = URI.create(catalogoUri);
		restTemplate = new RestTemplate();
		
	    return restTemplate.getForObject(uri, List.class);
	}

	public List<Libro> callbackFailure() {
		log.debug("callbackFailure(");
		return new ArrayList<Libro>();
	}
}

package es.jmpalma.atackathon.favorito.service;

import java.util.List;

import es.jmpalma.atackathon.favorito.dto.Libro;

public interface ServicioFavorito {

	List<Libro> obtenerListaFavoritos();
}

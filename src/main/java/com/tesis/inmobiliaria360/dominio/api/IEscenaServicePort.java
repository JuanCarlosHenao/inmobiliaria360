package com.tesis.inmobiliaria360.dominio.api;

import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaServicePort {

    void saveEscena(Escena escena);
    List<Escena> getAllEscenas();

    Escena getEscenaById(Long id);

    List<Escena> getAllEscenasByInmuebleId(Long inmuebleId);


//    String registrarInmueble (Inmueble inmueble);
//    String eliminarInmueble (Inmueble inmueble);
//    String actualizarInmueble(Inmueble inmueble);
//    Inmueble obtenerInmueble (Long id);

}

package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaPersistencePort {

    Escena saveEscena(Escena escena);
    List<Escena> getAllEscenas();

    Escena getEscenaById(Long id);

    List<Escena> getAllEscenasByInmuebleId(Long inmuebleId);


//    String saveInmueble(Inmueble inmueble);
//    String deleteInmueble(Inmueble inmueble);
//    String updateInmueble(Inmueble inmueble);
//    Inmueble getInmueble(Long id);
}

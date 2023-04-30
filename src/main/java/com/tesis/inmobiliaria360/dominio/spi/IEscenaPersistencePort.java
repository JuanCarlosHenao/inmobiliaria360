package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaPersistencePort {

    Escena saveEscena(Escena escena);
    List<Escena> getAllEscenas();


//    String saveInmueble(Inmueble inmueble);
//    String deleteInmueble(Inmueble inmueble);
//    String updateInmueble(Inmueble inmueble);
//    Inmueble getInmueble(Long id);
}

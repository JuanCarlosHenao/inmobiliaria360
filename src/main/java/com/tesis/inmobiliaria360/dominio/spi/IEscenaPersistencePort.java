package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaPersistencePort {

    Escena saveEscena(Escena escena);
    List<Escena> getAllEscenas();
}

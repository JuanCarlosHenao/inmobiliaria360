package com.tesis.inmobiliaria360.dominio.api;

import com.tesis.inmobiliaria360.dominio.model.Escena;

import java.util.List;

public interface IEscenaServicePort {

    void saveEscena(Escena escena);
    List<Escena> getAllEscenas();
}

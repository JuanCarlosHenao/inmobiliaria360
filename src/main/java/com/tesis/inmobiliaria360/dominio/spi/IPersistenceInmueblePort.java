package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;

public interface IPersistenceInmueblePort {

    String saveInmueble(Inmueble inmueble);
    String deleteInmueble(Inmueble inmueble);
    String updateInmueble(Inmueble inmueble);
    Inmueble getInmueble(Long id);
}

package com.tesis.inmobiliaria360.dominio.api;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;

import java.util.List;

public interface IInmuebleServicePort {
    String registrarInmueble (Inmueble inmueble);
    String eliminarInmueble (Inmueble inmueble);
    String actualizarInmueble(Inmueble inmueble);
    Inmueble obtenerInmueble (Long id);

    List<Inmueble> obtenerInmuebles();
}

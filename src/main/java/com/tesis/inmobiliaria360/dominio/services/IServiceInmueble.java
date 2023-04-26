package com.tesis.inmobiliaria360.dominio.services;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;

public interface IServiceInmueble {
    String registrarInmueble (Inmueble inmueble);
    String eliminarInmueble (Inmueble inmueble);
    String actualizarInmueble(Inmueble inmueble);
    Inmueble obtenerInmueble (Long id);


}

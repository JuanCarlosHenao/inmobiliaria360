package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;

import java.util.List;

public interface IInmueblePersistencePort {
    String saveInmueble(Inmueble inmueble);
    String deleteInmueble(Inmueble inmueble);
    String updateInmueble(Inmueble inmueble);
    Inmueble getInmueble(Long id);

    List<Inmueble> getAllInmuebles();
}

package com.tesis.inmobiliaria360.dominio.serviceImpl;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.dominio.services.IServiceInmueble;
import com.tesis.inmobiliaria360.dominio.spi.IPersistenceInmueblePort;
import com.tesis.inmobiliaria360.dominio.util.DomainConstants;
import org.springframework.beans.factory.annotation.Autowired;

public class InmuebleServiceImpl implements IServiceInmueble {
    @Autowired
    IPersistenceInmueblePort iPersistenceInmueblePort;

    @Override
    public String registrarInmueble(Inmueble inmueble) {
        if(inmueble!=null){
            iPersistenceInmueblePort.saveInmueble(inmueble);
            return DomainConstants.RETURN_INMUEBLE_CREATED;
        } else {
            return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
        }
    }

    @Override
    public String eliminarInmueble(Inmueble inmueble) {
        if(inmueble!=null){
            iPersistenceInmueblePort.deleteInmueble(inmueble);
            return DomainConstants.RETURN_INMUEBLE_DELETED;
        } else {
            return DomainConstants.RETURN_INMUEBLE_DELETED_ERROR;
        }
    }

    @Override
    public String actualizarInmueble(Inmueble inmueble) {
        if(inmueble.getId()!=null){
            iPersistenceInmueblePort.updateInmueble(inmueble);
            return DomainConstants.RETURN_INMUEBLE_UPDATED;
        } else {
            return DomainConstants.RETURN_INMUEBLE_UPDATED_ERROR;
        }
    }

    @Override
    public Inmueble obtenerInmueble(Long id) {
        if( id != null){
            return iPersistenceInmueblePort.getInmueble(id);
        }
        return null;
    }
}

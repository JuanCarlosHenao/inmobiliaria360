package com.tesis.inmobiliaria360.infraestructura.adapters.persistence;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.dominio.spi.IPersistenceInmueblePort;
import com.tesis.inmobiliaria360.dominio.util.DomainConstants;
import com.tesis.inmobiliaria360.infraestructura.adapters.mappers.InmuebleMapper;
import com.tesis.inmobiliaria360.infraestructura.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InmueblePersistenceAdapter  implements IPersistenceInmueblePort {
    @Autowired
    InmuebleRepository inmuebleRepository;
    @Autowired
    InmuebleMapper inmuebleMapper;
    @Override
    public String saveInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.save(inmuebleMapper.inmuebleDomainToInmuebleEntity(inmueble));
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
        }
        return  DomainConstants.RETURN_INMUEBLE_CREATED;
    }

    @Override
    public String deleteInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.delete(inmuebleMapper.inmuebleDomainToInmuebleEntity(inmueble));
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_DELETED_ERROR;
        }
        return  DomainConstants.RETURN_INMUEBLE_DELETED;
    }

    @Override
    public String updateInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.save(inmuebleMapper.inmuebleDomainToInmuebleEntity(inmueble));
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_UPDATED_ERROR;
        }
        return  DomainConstants.RETURN_INMUEBLE_UPDATED;
    }

    @Override
    public Inmueble getInmueble(Long id) {
        try {
            return inmuebleMapper.inmuebleEntityToInmuebleDomain(inmuebleRepository.findById(id).get());
        } catch (Exception e){
        }
        return null;
    }
}

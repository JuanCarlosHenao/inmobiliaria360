package com.tesis.inmobiliaria360.dominio.usecase;

import com.tesis.inmobiliaria360.dominio.api.IInmuebleServicePort;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.dominio.spi.IInmueblePersistencePort;
import com.tesis.inmobiliaria360.dominio.util.DomainConstants;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class InmuebleUseCase implements IInmuebleServicePort {
//    @Autowired
    private final IInmueblePersistencePort iInmueblePersistencePort;

    public InmuebleUseCase(IInmueblePersistencePort iInmueblePersistencePort) {
        this.iInmueblePersistencePort = iInmueblePersistencePort;
    }


    @Override
    public String registrarInmueble(Inmueble inmueble) {
        if(inmueble!=null){

//            return DomainConstants.RETURN_INMUEBLE_CREATED;
            inmueble.setCreatedDate(LocalDateTime.now());
            if (Objects.equals(iInmueblePersistencePort.saveInmueble(inmueble), DomainConstants.RETURN_INMUEBLE_CREATED)){
                return DomainConstants.RETURN_INMUEBLE_CREATED;
            }else {
                return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
            }
        } else {
            return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
        }
    }

    @Override
    public String eliminarInmueble(Inmueble inmueble) {
        if(inmueble!=null){
            iInmueblePersistencePort.deleteInmueble(inmueble);
            return DomainConstants.RETURN_INMUEBLE_DELETED;
        } else {
            return DomainConstants.RETURN_INMUEBLE_DELETED_ERROR;
        }
    }

    @Override
    public String actualizarInmueble(Inmueble inmueble) {
        if(inmueble.getId()!=null){
            iInmueblePersistencePort.updateInmueble(inmueble);
            return DomainConstants.RETURN_INMUEBLE_UPDATED;
        } else {
            return DomainConstants.RETURN_INMUEBLE_UPDATED_ERROR;
        }
    }

    @Override
    public Inmueble obtenerInmueble(Long id) {
        if( id != null){
            return iInmueblePersistencePort.getInmueble(id);
        }
        return null;
    }

    @Override
    public List<Inmueble> obtenerInmuebles() {
        return iInmueblePersistencePort.getAllInmuebles();
    }
}

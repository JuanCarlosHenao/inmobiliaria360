package com.tesis.inmobiliaria360.infraestructura.output.adapter;

import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import com.tesis.inmobiliaria360.dominio.spi.IInmueblePersistencePort;
import com.tesis.inmobiliaria360.dominio.util.DomainConstants;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IInmuebleEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.InmuebleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InmuebleJpaAdapter implements IInmueblePersistencePort {
//    @Autowired
    private final InmuebleRepository inmuebleRepository;

//    @Autowired
    private final IInmuebleEntityMapper iInmuebleEntityMapper;



    @Override
    public String saveInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.save(iInmuebleEntityMapper.inmuebleDomainToInmuebleEntity(inmueble));
            return  DomainConstants.RETURN_INMUEBLE_CREATED;
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
        }

    }

    @Override
    public String deleteInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.delete(iInmuebleEntityMapper.inmuebleDomainToInmuebleEntity(inmueble));
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_DELETED_ERROR;
        }
        return  DomainConstants.RETURN_INMUEBLE_DELETED;
    }

    @Override
    public String updateInmueble(Inmueble inmueble) {
        try {
            inmuebleRepository.save(iInmuebleEntityMapper.inmuebleDomainToInmuebleEntity(inmueble));
        } catch (Exception e){
            return DomainConstants.RETURN_INMUEBLE_UPDATED_ERROR;
        }
        return  DomainConstants.RETURN_INMUEBLE_UPDATED;
    }

    @Override
    public Inmueble getInmueble(Long id) {
        try {
            return iInmuebleEntityMapper.inmuebleEntityToInmuebleDomain(inmuebleRepository.findById(id).get());
        } catch (Exception e){
        }
        return null;
    }

    @Override
    public List<Inmueble> getAllInmuebles() {
        try {
            return iInmuebleEntityMapper.inmuebleEntityListToInmuebleDomainList(inmuebleRepository.findAll());
        } catch (Exception e){
        }
        return null;
    }
}

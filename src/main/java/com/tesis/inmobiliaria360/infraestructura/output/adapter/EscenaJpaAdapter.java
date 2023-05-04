package com.tesis.inmobiliaria360.infraestructura.output.adapter;

import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.spi.IEscenaPersistencePort;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IEscenaEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.EscenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


// La pregunta acá es si no estaría accediendo desde la infraestructura al dominio

@RequiredArgsConstructor
public class EscenaJpaAdapter implements IEscenaPersistencePort {

//    @Autowired
    private final EscenaRepository escenaRepository;
//    @Autowired
    private final IEscenaEntityMapper escenaEntityMapper;


    @Override
    public Escena saveEscena(Escena escena) {
        EscenaEntity escenaEntity =escenaRepository.save(escenaEntityMapper.toEscenaEntity(escena));
        return escenaEntityMapper.toEscena(escenaEntity);
    }

    @Override
    public List<Escena> getAllEscenas() {
        List<EscenaEntity> escenaEntityList  = escenaRepository.findAll();
        // añadir excepcion si no hay datos
        return escenaEntityMapper.toEscenaList(escenaEntityList);
    }  // implmenta la interfaz del dominio

    @Override
    public Escena getEscenaById(Long id) {
        try {
            return escenaEntityMapper.toEscena(escenaRepository.findById(id).get());
        } catch (Exception e){
        }
        return null;
    }

    @Override
    public List<Escena> getAllEscenasByInmuebleId(Long inmuebleId) {
        try {
            return escenaEntityMapper.toEscenaList(escenaRepository.findEscenaEntityByInmuebleId(inmuebleId));
        } catch (Exception e){
        }
        return null;
    }
}



//    @Autowired
//    InmuebleRepository inmuebleRepository;
//    @Autowired
//    InmuebleMapper inmuebleMapper;
//    @Override
//    public String saveInmueble(Inmueble inmueble) {
//        try {
//            inmuebleRepository.save(inmuebleMapper.inmuebleDomainToInmuebleEntity(inmueble));
//        } catch (Exception e){
//            return DomainConstants.RETURN_INMUEBLE_CREATED_ERROR;
//        }
//        return  DomainConstants.RETURN_INMUEBLE_CREATED;
//    }
package com.tesis.inmobiliaria360.infraestructura.output.adapter;

import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.spi.IEscenaPersistencePort;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IEscenaEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.EscenaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


// La pregunta acá es si no estaría accediendo desde la infraestructura al dominio

@RequiredArgsConstructor
public class EscenaJpaAdapter implements IEscenaPersistencePort {
    private final EscenaRepository escenaRepository;
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
}

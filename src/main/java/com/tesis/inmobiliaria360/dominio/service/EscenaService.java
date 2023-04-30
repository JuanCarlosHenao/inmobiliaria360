package com.tesis.inmobiliaria360.dominio.service;


import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import com.tesis.inmobiliaria360.infraestructura.output.repository.EscenaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EscenaService {

    private final EscenaRepository escenaRepository;


    public EscenaService(EscenaRepository escenaRepository) {
        this.escenaRepository = escenaRepository;
    }

    public Optional<EscenaEntity> findById(Long id) {
        return escenaRepository.findById(id);
    }

    public List<EscenaEntity> findAll() {

        return escenaRepository.findAll();
    }

    public EscenaEntity save(EscenaEntity escenaEntity) {
        EscenaEntity escenaEntityAGuardar = new EscenaEntity(
                escenaEntity.getId(),
                escenaEntity.getInmuebleEntity(),
                escenaEntity.getImage(),
                escenaEntity.getTitle(),
                escenaEntity.getPitch(),
                escenaEntity.getYaw(),
                null
//                escenaEntity.getHotSpotEntityList()
//                escenaEntity.getInmueble_id(),
//                null

        );
        return escenaRepository.save(escenaEntityAGuardar);
    }
}

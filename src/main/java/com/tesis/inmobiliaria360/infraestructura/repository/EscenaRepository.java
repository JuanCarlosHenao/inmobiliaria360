package com.tesis.inmobiliaria360.infraestructura.repository;


import com.tesis.inmobiliaria360.infraestructura.entity.EscenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EscenaRepository extends JpaRepository<EscenaEntity,Long> {

    Optional<EscenaEntity> findById(Long id);
    List<EscenaEntity> findAll();

    EscenaEntity save (EscenaEntity escenaEntity);
    //Buscar escenas x inmueble



}

package com.tesis.inmobiliaria360.infraestructura.output.repository;

import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InmuebleRepository extends JpaRepository<InmuebleEntity,Long> {

    Optional<InmuebleEntity> findById(Long id);
    List<InmuebleEntity> findAll();


}

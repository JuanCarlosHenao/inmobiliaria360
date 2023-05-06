package com.tesis.inmobiliaria360.infraestructura.output.repository;

import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.HotSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IHotSpotRepository extends JpaRepository<HotSpotEntity,Long> {

    Optional<HotSpotEntity> findById(Long id);
    List<HotSpotEntity> findAll();

    HotSpotEntity save (HotSpotEntity hotSpotEntity);
    //Buscar escenas x inmueble

    List<HotSpotEntity> findHotSpotEntityByEscenaId(Long id);


}

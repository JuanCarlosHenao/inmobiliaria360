package com.tesis.inmobiliaria360.infraestructura.output.repository;

import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.HotSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHotSpotRepository extends JpaRepository<HotSpotEntity,Long> {

}

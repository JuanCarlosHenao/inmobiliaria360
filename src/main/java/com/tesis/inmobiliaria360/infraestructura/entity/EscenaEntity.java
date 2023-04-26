package com.tesis.inmobiliaria360.infraestructura.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "Escena")
public class EscenaEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "escena_id", nullable = false)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "inmueble_id")//porque tengo muchas escenas para una propuedad
    private InmuebleEntity inmuebleEntity;
    @Column(name= "title", nullable = false)
    private String title;
    @Column(name= "image", nullable = false)
    private String image;

    @Column(name= "pitch", nullable = false)
    private Double pitch;

    @Column(name= "yaw", nullable = false)
    private Double yaw;

    @OneToMany(mappedBy = "escenaEntity")
    private List<HotSpotEntity> hotSpotEntityList;

}

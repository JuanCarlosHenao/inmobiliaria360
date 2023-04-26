package com.tesis.inmobiliaria360.infraestructura.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "HotSpot")
public class HotSpotEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "hotspot_id", nullable = false)
    private Long id;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "pitch",nullable = false)
    private Double pitch;
    @Column(name = "yaw",nullable = false)
    private Double yaw;
    @Column(name = "cssClass",nullable = false)
    private String cssClass;
    @Column(name = "nextScene",nullable = true)
    private String nextScene;

    //@ManyToOne(fetch = FetchType.LAZY)  //porque tengo muchas escenas para una propuedad
@ManyToOne()
    private EscenaEntity escenaEntity;


}

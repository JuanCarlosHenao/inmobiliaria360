package com.tesis.inmobiliaria360.infraestructura.output.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HotSpot")
public class HotSpotEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "hotspot_id", nullable = false)
    private Long id;
    @Column(name="name", nullable = false)
    private String name ;
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

//    @ManyToOne(fetch = FetchType.LAZY)  //porque tengo muchas escenas para una propuedad
//    private EscenaEntity escenaEntity;

    @ManyToOne
    @JoinColumn(name = "escena_id")//porque tengo muchas escenas para una propuedad
    private EscenaEntity escena;

    public HotSpotEntity(){
        super();
    }

    public HotSpotEntity(Long id, String name, String type, Double pitch, Double yaw, String cssClass, String nextScene, EscenaEntity escena) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pitch = pitch;
        this.yaw = yaw;
        this.cssClass = cssClass;
        this.nextScene = nextScene;
        this.escena = escena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPitch() {
        return pitch;
    }

    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    public Double getYaw() {
        return yaw;
    }

    public void setYaw(Double yaw) {
        this.yaw = yaw;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getNextScene() {
        return nextScene;
    }

    public void setNextScene(String nextScene) {
        this.nextScene = nextScene;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EscenaEntity getEscena() {
        return escena;
    }

    public void setEscena(EscenaEntity escena) {
        this.escena = escena;
    }
}

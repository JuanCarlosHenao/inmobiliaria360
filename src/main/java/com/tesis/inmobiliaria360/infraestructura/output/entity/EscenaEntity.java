package com.tesis.inmobiliaria360.infraestructura.output.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Escena")
public class EscenaEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "escena_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  //porque tengo muchas escenas para una propuedad
    private InmuebleEntity inmuebleEntity;
    @Column(name= "title", nullable = false)
    private String title;
    @Column(name= "image", nullable = false)
    private String image;

    @Column(name= "pitch", nullable = false)
    private Double pitch;
    @Column(name= "yaw", nullable = false)
    private Double yaw;

    public EscenaEntity(){
        super();
    }

    public EscenaEntity(Long id, InmuebleEntity inmuebleEntity, String title, String image, Double pitch, Double yaw) {
        this.id = id;
        this.inmuebleEntity = inmuebleEntity;
        this.title = title;
        this.image = image;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InmuebleEntity getInmuebleEntity() {
        return inmuebleEntity;
    }

    public void setInmuebleEntity(InmuebleEntity inmuebleEntity) {
        this.inmuebleEntity = inmuebleEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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


}

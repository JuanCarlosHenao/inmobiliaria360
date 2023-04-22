package com.tesis.inmobiliaria360.infraestructura.output.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Inmueble")
public class InmuebleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "inmueble_id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    //    @Size(max=100)
//    @BatchSize(size = 100)
    private String name;
    @Column(name = "price",nullable = false)
    //    @Size(max=100)
    private Double price;
    @Column(name = "description",nullable = false)
    //    @Size(max=300)
    private String description;
    @Column(name = "image",nullable = false)
    //    @Size(max=100)
    private String image;
    @CreatedDate
    @Column(name = "createdDate",nullable = false)
    //    @Size(max=100)
    private LocalDateTime createdDate;

    @OneToMany(cascade = CascadeType.ALL) // para que cada cambio en el inmueble me actualice las escenas
    @JoinColumn(name="inmueble_id")
    private List<EscenaEntity> escenaEntityList;

    public InmuebleEntity(){
        super();
    }

    public InmuebleEntity(Long id, String name, Double price, String description, String image, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public List<EscenaEntity> getEscenaEntityList() {
        return escenaEntityList;
    }

    public void setEscenaEntityList(List<EscenaEntity> escenaEntityList) {
        this.escenaEntityList = escenaEntityList;
    }
}

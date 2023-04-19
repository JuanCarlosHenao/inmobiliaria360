package com.tesis.inmobiliaria360.infraestructura.output.entity;

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

    @Column(name = "nombre",nullable = false)
    //    @Size(max=100)
//    @BatchSize(size = 100)
    private String nombre;
    @Column(name = "precio",nullable = false)
    //    @Size(max=100)
    private Double precio;
    @Column(name = "descripcion",nullable = false)
    //    @Size(max=300)
    private String descripcion;
    @Column(name = "imagen",nullable = false)
    //    @Size(max=100)
    private String imagen;
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
    public InmuebleEntity(Long id, String nombre, Double precio, String descripcion, String imagen, LocalDateTime createdDate, List<EscenaEntity> escenaEntityList) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.createdDate = createdDate;
        this.escenaEntityList = escenaEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double preci) {
        this.precio = preci;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

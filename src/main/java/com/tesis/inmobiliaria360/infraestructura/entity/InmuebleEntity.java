package com.tesis.inmobiliaria360.infraestructura.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)  // revisar
@Table(name = "Inmueble")
public class InmuebleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "inmueble_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    //    @Size(max=100)
//    @BatchSize(size = 100)
    private String name;
    @Column(name = "price", nullable = false)
    //    @Size(max=100)
    private Double price;
    @Column(name = "description", nullable = false)
    //    @Size(max=300)
    private String description;
    @Column(name = "image", nullable = false)
    //    @Size(max=100)
    private String image;
    @CreatedDate
    @Column(name = "createdDate", nullable = false)
    //    @Size(max=100)
    private LocalDateTime createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inmuebleEntity")
    private List<EscenaEntity> escenaEntityList;

}
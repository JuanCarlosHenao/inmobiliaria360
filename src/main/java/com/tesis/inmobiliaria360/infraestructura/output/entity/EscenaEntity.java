package com.tesis.inmobiliaria360.infraestructura.output.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "Escena")
public class EscenaEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //aumenta el id de uno en uno
    @Id
    @Column(name = "escena_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "inmueble_id")//porque tengo muchas escenas para una propiedad
    private InmuebleEntity inmueble;
    @Column(name= "title", nullable = false)
    private String title;
    @Column(name= "image", nullable = false)
    private String image;

    @Column(name= "pitch", nullable = false)
    private Double pitch;

    @Column(name= "yaw", nullable = false)
    private Double yaw;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "escena")
    private List<HotSpotEntity> hotSpotEntityList;

}

package com.tesis.inmobiliaria360.aplicacion;

import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//import org.hibernate.validator.constraints.URL;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EscenaDto {
    private Long id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;
    private List<HotSpot> hotSpotList;

    public EscenaDto(Long id, String title, String image, Double pitch, Double yaw, List<HotSpot> hotSpotList) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.pitch = pitch;
        this.yaw = yaw;
        this.hotSpotList = hotSpotList;
    }
}

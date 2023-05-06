package com.tesis.inmobiliaria360.aplicacion.dto.response;

import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import lombok.*;

import java.util.List;

//import org.hibernate.validator.constraints.URL;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

//@Getter
//@Setter
//@RequiredArgsConstructor
@Data
public class EscenaResponseDto {
    private Long id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;
    private List<HotSpotResponseDto> hotSpotResponseDtoList;
//    private Inmueble inmueble;
//    private List<HotSpot> hotSpotList;
    // acá iría el id del inmueble al cuál pertenece

//    public EscenaResponseDto(Long id, String title, String image, Double pitch, Double yaw) {
//        this.id = id;
//        this.title = title;
//        this.image = image;
//        this.pitch = pitch;
//        this.yaw = yaw;
////        this.hotSpotList = hotSpotList;
//    }

//    public EscenaResponseDto(Long id, String title, String image, Double pitch, Double yaw) {
//        this.id = id;
//        this.title = title;
//        this.image = image;
//        this.pitch = pitch;
//        this.yaw = yaw;
////        this.inmueble = inmueble;
//    }


//    public EscenaResponseDto(Long id, String title, String image, Double pitch, Double yaw, List<HotSpotResponseDto> hotSpotResponseDtoList) {
//        this.id = id;
//        this.title = title;
//        this.image = image;
//        this.pitch = pitch;
//        this.yaw = yaw;
//        this.hotSpotResponseDtoList = hotSpotResponseDtoList;
//    }
}

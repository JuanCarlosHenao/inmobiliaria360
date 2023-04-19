package com.tesis.inmobiliaria360.aplicacion;

import lombok.Getter;
import lombok.Setter;

//import org.hibernate.validator.constraints.URL;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EscenaDto {
    private final Long id;

//    @NotNull(message = "description is required")
//    @Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
    private final String title;
//    @NotNull(message = "image is required")
//    @URL(message = "image must be a URL")
    private final String image;


//    @NotNull(message = "pitch es requerido")
    private final Double pitch;

//    @NotNull(message = "yaw es requerido")
    private final Double yaw;

    public EscenaDto(Long id, String title, String image, Double pitch, Double yaw) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.pitch = pitch;
        this.yaw = yaw;
    }
}

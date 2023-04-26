package com.tesis.inmobiliaria360.infraestructura.rest;


import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
//import com.tesis.inmobiliaria360.aplicacion.handler.impl.EscenaHandler;
//import com.tesis.inmobiliaria360.dominio.service.EscenaService;
import com.tesis.inmobiliaria360.dominio.service.EscenaService;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inmobiliaria360/inmueble/escena")

public class EscenaController {

//    private final IEscenaHandler escenaHandler;
//
//    public EscenaController(IEscenaHandler escenaHandler) {
//        this.escenaHandler = escenaHandler;
//    }

        private final EscenaService escenaService;

    public EscenaController(EscenaService escenaService) {
        this.escenaService = escenaService;
    }


    @GetMapping("/escenas")
    public ResponseEntity<List<EscenaEntity>> findAllEscenas(){

        return ResponseEntity.ok(escenaService.findAll()) ;
    }

    @GetMapping("/escenas/{id}")
    public ResponseEntity<Optional<EscenaEntity>> findById(@RequestParam(value = "id", defaultValue = "0") Long id){
        return ResponseEntity.ok(escenaService.findById(id));

    }

    @PostMapping("/publicarEscena")
    public ResponseEntity<EscenaEntity> postInmueble (@RequestBody EscenaEntity escenaEntity){
        return ResponseEntity.created(URI.create("/inmobiliaria360/inmueble/escena/publicarEscena"))  // cambia el http código de respuesta
                .body(escenaService.save(escenaEntity));
    }

//    @GetMapping("/escenas")
//    public ResponseEntity<List<EscenaResponseDto>> findAllEscenas(){
//
//        return ResponseEntity.ok(escenaHandler.getAllEscenas()) ;
//    }
//
//    @PostMapping("/publicarEscena")
//    public ResponseEntity<Void>saveEscena(@RequestBody EscenaRequestDto escenaRequestDto ){
//        escenaHandler.saveEscena(escenaRequestDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}

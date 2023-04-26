package com.tesis.inmobiliaria360.infraestructura.rest;


import com.tesis.inmobiliaria360.dominio.serviceImpl.EscenaService;
import com.tesis.inmobiliaria360.infraestructura.entity.EscenaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inmobiliaria360/inmueble/escena")
public class EscenaController {



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
}

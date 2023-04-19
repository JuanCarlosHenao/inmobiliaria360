package com.tesis.inmobiliaria360.infraestructura.rest;

import com.tesis.inmobiliaria360.aplicacion.EscenaDto;
import com.tesis.inmobiliaria360.dominio.InmuebleService;
import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inmobiliaria360")
public class InmuebleController {

    private final InmuebleService inmuebleService; // para la inyeción de dependencias

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }


    @GetMapping("/inmuebles")
    public ResponseEntity<List<InmuebleEntity>> findAllInmuebles(){
        return ResponseEntity.ok(inmuebleService.findAll()) ;
    }

    @GetMapping("/inmueble/{id}")
    public ResponseEntity<Optional<InmuebleEntity>> findById(@RequestParam(value = "id", defaultValue = "0") Long id){
        return ResponseEntity.ok(inmuebleService.findById(id));

    }

    @PostMapping("/publicarInmueble")
    public ResponseEntity<InmuebleEntity> postInmueble (@RequestBody InmuebleEntity inmuebleEntity){
        return ResponseEntity.created(URI.create("/inmobiliaria360/publicarInmueble"))  // cambia el http código de respuesta
                .body(inmuebleService.save(inmuebleEntity));
    }

}

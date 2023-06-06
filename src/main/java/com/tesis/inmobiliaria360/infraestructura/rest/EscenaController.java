package com.tesis.inmobiliaria360.infraestructura.rest;
import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.request.InmuebleRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
//import com.tesis.inmobiliaria360.aplicacion.handler.impl.EscenaHandler;
//import com.tesis.inmobiliaria360.dominio.service.EscenaService;
import com.tesis.inmobiliaria360.aplicacion.handler.impl.EscenaHandler;
import com.tesis.inmobiliaria360.dominio.service.EscenaService;
import com.tesis.inmobiliaria360.infraestructura.output.entity.EscenaEntity;
import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inmobiliaria360/inmueble/escena")

public class EscenaController {
    private final IEscenaHandler escenaHandler;  // preguntar si se trae la interfaz o la clase

    public EscenaController(IEscenaHandler escenaHandler) {
        this.escenaHandler = escenaHandler;
    }


    @GetMapping("/escenas")
    public ResponseEntity<List<EscenaResponseDto>> findAllEscenas(){
        return ResponseEntity.ok(escenaHandler.getAllEscenas()) ;
    }

    @GetMapping("/escenaSola/{id}")
    public EscenaResponseDto getEscenaById(@PathVariable("id") Long id){
        return escenaHandler.getEscenaById(id);
    }

    @PostMapping("/publicarEscena")
    public ResponseEntity<Void>saveEscena(@RequestBody EscenaRequestDto escenaRequestDto ){
        escenaHandler.saveEscena(escenaRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/escenasByInmueble/{inmueble_id}")
    public ResponseEntity<List<EscenaResponseDto>> findAllEscenasByInmuebleid(@PathVariable("inmueble_id") Long inmueble_id){

        return ResponseEntity.ok(escenaHandler.getAllEscenasByInmuebleId(inmueble_id)) ;
    }

    @PutMapping("/actualizarEscena/{id}")
    public  ResponseEntity<EscenaResponseDto> updateEscena (@PathVariable("id") Long id,@RequestBody EscenaRequestDto escenaRequestDto){
        escenaHandler.updateEscena(id,escenaRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

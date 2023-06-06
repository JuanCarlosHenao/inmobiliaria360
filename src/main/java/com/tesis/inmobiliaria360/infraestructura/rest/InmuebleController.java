package com.tesis.inmobiliaria360.infraestructura.rest;

import com.tesis.inmobiliaria360.aplicacion.dto.request.EscenaRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.request.InmuebleRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IInmuebleHandler;
import com.tesis.inmobiliaria360.dominio.service.InmuebleService;
import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inmobiliaria360")
public class InmuebleController {

    private final IInmuebleHandler iInmuebleHandler;

    public InmuebleController(IInmuebleHandler iInmuebleHandler) {
        this.iInmuebleHandler = iInmuebleHandler;
    }

//    @GetMapping("/inmuebles")
//    public ResponseEntity<List<InmuebleEntity>> findAllInmuebles(){
//        return ResponseEntity.ok(iInmuebleHandler.findAll()) ;
//    }

    @GetMapping("/inmuebles")
    public ResponseEntity<List<InmuebleResponseDto>> findAllInmuebles(){

        return ResponseEntity.ok(iInmuebleHandler.getAllInmuebles()) ;
    }


    @GetMapping("/inmueble/{id}")
    public InmuebleResponseDto getInmuebleById(@PathVariable("id") Long id){
        return iInmuebleHandler.getInmuebleById(id);
    }

    @PostMapping("/publicarInmueble")
    public ResponseEntity<String> postInmueble (@RequestBody InmuebleRequestDto inmuebleRequestDto){
        iInmuebleHandler.saveInmueble(inmuebleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/actualizarInmueble/{id}")
    public  ResponseEntity<String> putInmueble (@PathVariable("id") Long id,@RequestBody InmuebleRequestDto inmuebleRequestDto){
        iInmuebleHandler.updateInmueble(id,inmuebleRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }





//    private final InmuebleService inmuebleService; // para la inyeción de dependencias
//
//    public InmuebleController(InmuebleService inmuebleService) {
//        this.inmuebleService = inmuebleService;
//    }
//
//
//    @GetMapping("/inmuebles")
//    public ResponseEntity<List<InmuebleEntity>> findAllInmuebles(){
//        return ResponseEntity.ok(inmuebleService.findAll()) ;
//    }
//
//    @GetMapping("/inmueble/{id}")
//    public ResponseEntity<Optional<InmuebleEntity>> findById(@RequestParam(value = "id", defaultValue = "0") Long id){
//        return ResponseEntity.ok(inmuebleService.findById(id));
//
//    }
//
//    @PostMapping("/publicarInmueble")
//    public ResponseEntity<InmuebleEntity> postInmueble (@RequestBody InmuebleEntity inmuebleEntity){
//        return ResponseEntity.created(URI.create("/inmobiliaria360/publicarInmueble"))  // cambia el http código de respuesta
//                .body(inmuebleService.save(inmuebleEntity));
//    }

}

package com.tesis.inmobiliaria360.infraestructura.rest;


import com.tesis.inmobiliaria360.aplicacion.dto.request.HotSpotRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.HotSpotResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.impl.HotSpotHandler;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/inmobiliaria360/inmueble/escena/hotspot")
public class HotSpotController {

    private final HotSpotHandler hotSpotHandler;  // preguntar si lo que traigo acá es la clase handler o la interfaz

    public HotSpotController(HotSpotHandler hotSpotHandler) {
        this.hotSpotHandler = hotSpotHandler;
    }

    @GetMapping("/")
    public ResponseEntity<List<HotSpotResponseDto>> getAllHotSpots(){
        return ResponseEntity.ok(hotSpotHandler.getAllHotSpots());
    }

    @PostMapping("/savehotspot")
    public ResponseEntity<Void> saveHotSpot(@RequestBody HotSpotRequestDto hotSpotRequestDto){
        hotSpotHandler.saveHotSpot(hotSpotRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

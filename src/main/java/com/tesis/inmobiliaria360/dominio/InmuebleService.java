package com.tesis.inmobiliaria360.dominio;


import com.tesis.inmobiliaria360.infraestructura.output.entity.InmuebleEntity;
import com.tesis.inmobiliaria360.infraestructura.output.repository.InmuebleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {

    private final InmuebleRepository inmuebleRepository;

    public InmuebleService(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

//    public List<InmuebleDto> findAllInmuebles (){
//        return List.of(
//                new InmuebleDto(1L,"Interior 1","https://cdn.auth0.com/blog/whatabyte/burger-sm.png",-11.0,-3.0),
//                new InmuebleDto(2L,"Interior 2","https://cdn.auth0.com/blog/whatabyte/pizza-sm.png",10.0,180.0),
//                new InmuebleDto(3L,"Interior 3","https://cdn.auth0.com/blog/whatabyte/tea-sm.png",-11.0,-3.0)
//        );
//    }

//    public InmuebleDto findById (Long id){
//        return  new InmuebleDto(id,"Interior 4", "https://cdn.auth0.com/blog/whatabyte/tea-sm.png",-11.0,-3.0);
//    }

//    public InmuebleDto postInmueble (InmuebleDto inmuebleDto){
//        return  new InmuebleDto(5L,"Interior 5", "https://cdn.auth0.com/blog/whatabyte/tea-sm.png",-11.0,-3.0);
//    }

    public List<InmuebleEntity> findAll(){
        return inmuebleRepository.findAll();
    }

    public Optional<InmuebleEntity> findById(Long id){
        return inmuebleRepository.findById(id);
    }

    public InmuebleEntity save(InmuebleEntity inmuebleEntity){
        InmuebleEntity inmuebleEntityAGuardar = new InmuebleEntity(
                inmuebleEntity.getId(),
                inmuebleEntity.getNombre(),
                inmuebleEntity.getPrecio(),
                inmuebleEntity.getDescripcion(),
                inmuebleEntity.getImagen(),
                LocalDateTime.now(),
                null

        );
        return inmuebleRepository.save(inmuebleEntityAGuardar);
    }


}

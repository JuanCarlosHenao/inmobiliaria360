package com.tesis.inmobiliaria360.aplicacion.handler.impl;

import com.tesis.inmobiliaria360.aplicacion.dto.request.InmuebleRequestDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.EscenaResponseDto;
import com.tesis.inmobiliaria360.aplicacion.dto.response.InmuebleResponseDto;
import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.IInmuebleHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.IInmuebleMapper;
import com.tesis.inmobiliaria360.dominio.api.IInmuebleServicePort;
import com.tesis.inmobiliaria360.dominio.model.Inmueble;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional  // para la parte transaccional de agregar las diferentes escenas

//@AllArgsConstructor
public class InmuebleHandler implements IInmuebleHandler {



    private final IInmuebleServicePort iInmuebleServicePort;
    private final IInmuebleMapper iInmuebleMapper;
    private final IEscenaHandler iEscenaHandler;

//    public InmuebleHandler(IInmuebleServicePort iInmuebleServicePort, IInmuebleMapper iInmuebleMapper) {
//        this.iInmuebleServicePort = iInmuebleServicePort;
//        this.iInmuebleMapper = iInmuebleMapper;
//    }


    @Override
    public String saveInmueble(InmuebleRequestDto inmuebleRequestDto) {
        return iInmuebleServicePort.registrarInmueble(
                iInmuebleMapper.inmuebleDtoRequestToInmuebleDomain(inmuebleRequestDto)
        );
    }

    @Override
    public String deleteInmueble(InmuebleRequestDto inmuebleRequestDto) {
        return iInmuebleServicePort.eliminarInmueble(
                iInmuebleMapper.inmuebleDtoRequestToInmuebleDomain(inmuebleRequestDto)
        );
    }

    @Override
    public String updateInmueble(Long id,InmuebleRequestDto inmuebleRequestDto) {
        InmuebleResponseDto inmuebleActualizar = getInmuebleById(id);
        inmuebleActualizar.setName(inmuebleRequestDto.getName());
        inmuebleActualizar.setPrice(inmuebleRequestDto.getPrice());
        inmuebleActualizar.setDescription(inmuebleRequestDto.getDescription());
        inmuebleActualizar.setImage(inmuebleRequestDto.getImage());
//        inmuebleActualizar.setEscenaResponseDtoList(inmuebleRequestDto.getEscenaRequestDtoList());


        return iInmuebleServicePort.actualizarInmueble(
//                iInmuebleMapper.inmuebleDtoRequestToInmuebleDomain(inmuebleRequestDto)
                iInmuebleMapper.inmuebleResponseDtotoInmuebleDomain(inmuebleActualizar)
        );
    }

    @Override
    public InmuebleResponseDto getInmuebleById(Long id) {
        List<EscenaResponseDto> escenaResponseDtoList = new ArrayList<>();
        escenaResponseDtoList = iEscenaHandler.getAllEscenasByInmuebleId(id);
        InmuebleResponseDto inmuebleResponseDto = iInmuebleMapper.inmuebleDomainToInmuebleDtoResponse(iInmuebleServicePort.obtenerInmueble(id));
        inmuebleResponseDto.setEscenaResponseDtoList(escenaResponseDtoList);
        return inmuebleResponseDto;
    }

    @Override
    public List<InmuebleResponseDto> getAllInmuebles() {
        List<EscenaResponseDto> escenaResponseDtoList = new ArrayList<>();
        List<InmuebleResponseDto> inmuebleResponseDtoList = iInmuebleMapper.inmuebleDomainListToInmuebleDtoResponseList(iInmuebleServicePort.obtenerInmuebles());

        for (InmuebleResponseDto inmuebleResponseDtoItem:inmuebleResponseDtoList) {
            inmuebleResponseDtoItem.setEscenaResponseDtoList(iEscenaHandler.getAllEscenasByInmuebleId(inmuebleResponseDtoItem.getId()));
        }
        return inmuebleResponseDtoList;
    }




}

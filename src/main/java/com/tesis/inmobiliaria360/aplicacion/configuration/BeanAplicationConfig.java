package com.tesis.inmobiliaria360.aplicacion.configuration;

import com.tesis.inmobiliaria360.aplicacion.handler.IEscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.IHotSpotHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.IInmuebleHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.impl.EscenaHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.impl.HotSpotHandler;
import com.tesis.inmobiliaria360.aplicacion.handler.impl.InmuebleHandler;
import com.tesis.inmobiliaria360.aplicacion.mapper.IInmuebleMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IEscenaRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.request.IHotSpotRequestMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IEscenaResponseMapper;
import com.tesis.inmobiliaria360.aplicacion.mapper.response.IHotSpotResponseMapper;
import com.tesis.inmobiliaria360.dominio.api.IEscenaServicePort;
import com.tesis.inmobiliaria360.dominio.api.IHotSpotServicePort;
import com.tesis.inmobiliaria360.dominio.api.IInmuebleServicePort;
import com.tesis.inmobiliaria360.dominio.spi.IEscenaPersistencePort;
import com.tesis.inmobiliaria360.dominio.spi.IHotSpotPersistencePort;
import com.tesis.inmobiliaria360.dominio.spi.IInmueblePersistencePort;
import com.tesis.inmobiliaria360.dominio.usecase.EscenaUseCase;
import com.tesis.inmobiliaria360.dominio.usecase.InmuebleUseCase;
import com.tesis.inmobiliaria360.infraestructura.output.adapter.EscenaJpaAdapter;
import com.tesis.inmobiliaria360.infraestructura.output.adapter.HotSpotJpaAdapter;
import com.tesis.inmobiliaria360.infraestructura.output.adapter.InmuebleJpaAdapter;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IEscenaEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IInmuebleEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.EscenaRepository;
import com.tesis.inmobiliaria360.infraestructura.output.repository.InmuebleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAplicationConfig {

    @Bean
    IEscenaHandler iEscenaHandler(IInmuebleServicePort iInmuebleServicePort,IEscenaServicePort escenaServicePort, IEscenaRequestMapper escenaRequestMapper, IEscenaResponseMapper escenaResponseMapper,IHotSpotHandler iHotSpotHandler){
        return new EscenaHandler(iInmuebleServicePort,escenaServicePort,escenaRequestMapper,escenaResponseMapper,iHotSpotHandler);
    }

    @Bean
    public IInmueblePersistencePort inmueblePersistencePort(InmuebleRepository inmuebleRepository , IInmuebleEntityMapper iInmuebleEntityMapper){
        return new InmuebleJpaAdapter(inmuebleRepository,iInmuebleEntityMapper);
    }
    @Bean
    public IInmuebleServicePort inmuebleServicePort(IInmueblePersistencePort iInmueblePersistencePort){
        return new InmuebleUseCase(iInmueblePersistencePort);
    }
    @Bean
    public IHotSpotHandler iHotSpotHandler(IHotSpotServicePort hotSpotServicePort,
    IHotSpotRequestMapper hotSpotRequestMapper,
    IHotSpotResponseMapper hotSpotResponseMapper, IEscenaServicePort iEscenaServicePort){
        return  new HotSpotHandler(hotSpotServicePort,hotSpotRequestMapper,hotSpotResponseMapper,iEscenaServicePort);
    }

}

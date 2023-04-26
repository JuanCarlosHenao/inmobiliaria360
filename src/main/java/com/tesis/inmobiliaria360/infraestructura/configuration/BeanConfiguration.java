package com.tesis.inmobiliaria360.infraestructura.configuration;

import com.tesis.inmobiliaria360.dominio.api.IHotSpotServicePort;
import com.tesis.inmobiliaria360.dominio.spi.IHotSpotPersistencePort;
import com.tesis.inmobiliaria360.dominio.usecase.HotSpotUseCase;
import com.tesis.inmobiliaria360.infraestructura.output.adapter.HotSpotJpaAdapter;
import com.tesis.inmobiliaria360.infraestructura.output.mapper.IHotSpotEntityMapper;
import com.tesis.inmobiliaria360.infraestructura.output.repository.IHotSpotRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@RequiredArgsConstructor
public class BeanConfiguration {
//    private final EscenaRepository escenaRepository;
//    private final IEscenaEntityMapper escenaEntityMapper;
//
//
//    public BeanConfiguration(EscenaRepository escenaRepository, IEscenaEntityMapper escenaEntityMapper) {
//        this.escenaRepository = escenaRepository;
//        this.escenaEntityMapper = escenaEntityMapper;
//    }
//
//    //
//    @Bean
//    public IEscenaPersistencePort escenaPersistencePort(){
//        return new EscenaJpaAdapter(this.escenaRepository,this.escenaEntityMapper);
//    }
////
//    @Bean
//    public IEscenaServicePort escenaServicePort(){
//        return new EscenaUseCase(this.escenaPersistencePort());
//    }
//
//
    private final IHotSpotRepository hotSpotRepository;
    private final IHotSpotEntityMapper hotSpotEntityMapper;


    public BeanConfiguration(IHotSpotRepository hotSpotRepository, IHotSpotEntityMapper hotSpotEntityMapper) {
        this.hotSpotRepository = hotSpotRepository;
        this.hotSpotEntityMapper = hotSpotEntityMapper;
    }

    @Bean
    public IHotSpotPersistencePort hotSpotPersistencePort(){
        return new HotSpotJpaAdapter(this.hotSpotRepository,this.hotSpotEntityMapper);
    }

    @Bean
    public IHotSpotServicePort hotSpotServicePort(){
        return new HotSpotUseCase(hotSpotPersistencePort());
    }
}

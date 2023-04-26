package com.tesis.inmobiliaria360.dominio.usecase;

import com.tesis.inmobiliaria360.dominio.api.IEscenaServicePort;
import com.tesis.inmobiliaria360.dominio.model.Escena;
import com.tesis.inmobiliaria360.dominio.spi.IEscenaPersistencePort;

import java.util.List;

public class EscenaUseCase implements IEscenaServicePort {

    private final IEscenaPersistencePort escenaPersistencePort;

    public EscenaUseCase(IEscenaPersistencePort escenaPersistencePort) {
        this.escenaPersistencePort = escenaPersistencePort;
    }

    @Override
    public void saveEscena(Escena escena) {
         escenaPersistencePort.saveEscena(escena);
    }

    @Override
    public List<Escena> getAllEscenas() {
        return escenaPersistencePort.getAllEscenas();
    }

}

package com.tesis.inmobiliaria360.dominio.usecase;

import com.tesis.inmobiliaria360.dominio.api.IHotSpotServicePort;
import com.tesis.inmobiliaria360.dominio.model.HotSpot;
import com.tesis.inmobiliaria360.dominio.spi.IHotSpotPersistencePort;

import java.util.List;

public class HotSpotUseCase implements IHotSpotServicePort {
    private final IHotSpotPersistencePort hotSpotPersistencePort;

    public HotSpotUseCase(IHotSpotPersistencePort hotSpotPersistencePort) {
        this.hotSpotPersistencePort = hotSpotPersistencePort;
    }

    @Override
    public void saveHotSpot(HotSpot hotSpot) {
        hotSpotPersistencePort.saveHotSpot(hotSpot);
    }

    @Override
    public List<HotSpot> getAllHotSpots() {
        return hotSpotPersistencePort.getAllHotSpots();
    }
}

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
    public HotSpot saveHotSpot(HotSpot hotSpot) {

        return hotSpotPersistencePort.saveHotSpot(hotSpot);
    }

    @Override
    public List<HotSpot> getAllHotSpots() {
        return hotSpotPersistencePort.getAllHotSpots();
    }

    @Override
    public HotSpot getHotSpotById(Long id) {
        return hotSpotPersistencePort.getHotSpotById(id);
    }

    @Override
    public List<HotSpot> getAllHotSpotByEscenaId(Long escenaId) {
        return hotSpotPersistencePort.getAllHotSpotByEscenaId(escenaId);
    }

    @Override
    public void updateHotSpot(HotSpot hotSpot) {
        hotSpotPersistencePort.updateHotSpot(hotSpot);
    }
}

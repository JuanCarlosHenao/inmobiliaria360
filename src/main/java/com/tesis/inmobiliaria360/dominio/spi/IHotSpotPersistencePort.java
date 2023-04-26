package com.tesis.inmobiliaria360.dominio.spi;

import com.tesis.inmobiliaria360.dominio.model.HotSpot;

import java.util.List;

public interface IHotSpotPersistencePort {
    HotSpot saveHotSpot ( HotSpot hotSpot);
    List<HotSpot> getAllHotSpots();

}

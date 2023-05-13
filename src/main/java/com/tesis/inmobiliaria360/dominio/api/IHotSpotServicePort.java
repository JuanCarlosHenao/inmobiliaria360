package com.tesis.inmobiliaria360.dominio.api;

import com.tesis.inmobiliaria360.dominio.model.HotSpot;

import java.util.List;

public interface IHotSpotServicePort {
    HotSpot saveHotSpot ( HotSpot hotSpot);
    List<HotSpot> getAllHotSpots();

    HotSpot getHotSpotById(Long id);
    List<HotSpot> getAllHotSpotByEscenaId(Long escenaId);

    void updateHotSpot(HotSpot hotSpot);
}

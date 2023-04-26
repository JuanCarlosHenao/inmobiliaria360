package com.tesis.inmobiliaria360.dominio.api;

import com.tesis.inmobiliaria360.dominio.model.HotSpot;

import java.util.List;

public interface IHotSpotServicePort {
    void saveHotSpot (HotSpot hotSpot);
    List<HotSpot> getAllHotSpots();

}

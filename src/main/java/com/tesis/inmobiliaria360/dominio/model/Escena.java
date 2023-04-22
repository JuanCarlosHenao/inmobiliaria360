package com.tesis.inmobiliaria360.dominio.model;

import java.util.List;

public class Escena {
    private Long id;
    private String title;
    private String image;
    private Double pitch;
    private Double yaw;

    private List<HotSpot> hotSpotList;

    public Escena(Long id, String title, String image, Double pitch, Double yaw, List<HotSpot> hotSpotList) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.pitch = pitch;
        this.yaw = yaw;
        this.hotSpotList = hotSpotList;  // mirar si esto si se lo paso o no
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPitch() {
        return pitch;
    }

    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    public Double getYaw() {
        return yaw;
    }

    public void setYaw(Double yaw) {
        this.yaw = yaw;
    }

    public List<HotSpot> getHotSpotList() {
        return hotSpotList;
    }

    public void setHotSpotList(List<HotSpot> hotSpotList) {
        this.hotSpotList = hotSpotList;
    }
}

package com.tesis.inmobiliaria360.dominio.model;

public class HotSpot {
    private Long id;
    private String type;
    private Double pitch;
    private Double yaw;

    private String cssClass;

    private String nextScene;


    public HotSpot(Long id, String type, Double pitch, Double yaw, String cssClass, String nextScene) {
        this.id = id;
        this.type = type;
        this.pitch = pitch;
        this.yaw = yaw;
        this.cssClass = cssClass;
        this.nextScene = nextScene;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getNextScene() {
        return nextScene;
    }

    public void setNextScene(String nextScene) {
        this.nextScene = nextScene;
    }
}

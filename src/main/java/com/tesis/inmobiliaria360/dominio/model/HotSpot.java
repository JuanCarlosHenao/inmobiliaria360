package com.tesis.inmobiliaria360.dominio.model;

public class HotSpot {
    private Long id;
    private String name ;
    private String type;
    private Double pitch;
    private Double yaw;

    private String cssClass;

    private String nextScene;

    private Escena escena;


    public HotSpot(Long id, String name, String type, Double pitch, Double yaw, String cssClass, String nextScene, Escena escena) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pitch = pitch;
        this.yaw = yaw;
        this.cssClass = cssClass;
        this.nextScene = nextScene;
        this.escena = escena;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Escena getEscena() {
        return escena;
    }

    public void setEscena(Escena escena) {
        this.escena = escena;
    }
}

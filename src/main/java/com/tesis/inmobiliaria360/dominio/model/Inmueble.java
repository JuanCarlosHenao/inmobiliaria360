package com.tesis.inmobiliaria360.dominio.model;

import java.time.LocalDateTime;
import java.util.List;

public class Inmueble {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String image;
    private LocalDateTime createdDate;

    private List<Escena> escenaList;

    public Inmueble(Long id, String name, Double price, String description, String image, LocalDateTime createdDate, List<Escena> escenaList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.createdDate = createdDate;
        this.escenaList = escenaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public List<Escena> getEscenaList() {
        return escenaList;
    }

    public void setEscenaList(List<Escena> escenaList) {
        this.escenaList = escenaList;
    }
}

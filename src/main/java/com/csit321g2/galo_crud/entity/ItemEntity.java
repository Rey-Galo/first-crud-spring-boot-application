package com.csit321g2.galo_crud.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid;
    private String name;
    private String unit;
    private float price;

    public ItemEntity() {
        // Required by JPA.
    }

    public ItemEntity(String name, String unit, float price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public int getItemid() {
        return itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

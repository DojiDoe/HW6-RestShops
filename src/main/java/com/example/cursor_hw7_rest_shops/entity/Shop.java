package com.example.cursor_hw7_rest_shops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String name;
    private int workersNum;
    private boolean isSite;

    public Shop(Long id, String city, String street, String name, int workersNum, boolean isSite) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.name = name;
        this.workersNum = workersNum;
        this.isSite = isSite;
    }

    public Shop(String city, String street, String name, int workersNum, boolean isSite) {
        this.city = city;
        this.street = street;
        this.name = name;
        this.workersNum = workersNum;
        this.isSite = isSite;
    }

    public Shop() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String cityName) {
        this.city = cityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String streetName) {
        this.street = streetName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkersNum() {
        return workersNum;
    }

    public void setWorkersNum(int workersNum) {
        this.workersNum = workersNum;
    }

    public boolean isSite() {
        return isSite;
    }

    public void setSite(boolean site) {
        isSite = site;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", name='" + name + '\'' +
                ", workersNum=" + workersNum +
                ", isSite=" + isSite +
                '}';
    }
}


package com.mofidx.mysqlexternaldatabase;

public class Car {
    int id;
    String model;
    String color;
    double dist;

    public Car(int id, String model, String color, double dist) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.dist = dist;
    }

    public Car(String model, String color, double dist) {
        this.model = model;
        this.color = color;
        this.dist = dist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }



}

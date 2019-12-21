package com.example.demo.entity;

public class Card {
    private int id;
    private String name;
    private String discribe;
    private int stars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String describe) {
        this.discribe = describe;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

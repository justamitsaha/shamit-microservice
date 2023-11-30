package com.saha.amit.springBasic.dao;

public class Giraffe {
    String name;
    int eyes =2;
    int leg =3;
    int tail =1;
    String neck;

    public Giraffe() {
    }

    public Giraffe(String name, int eyes, int leg, int tail, String neck) {
        this.name = name;
        this.eyes = eyes;
        this.leg = leg;
        this.tail = tail;
        this.neck = neck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}

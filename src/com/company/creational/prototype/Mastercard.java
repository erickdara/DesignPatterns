package com.company.creational.prototype;

public class Mastercard implements PrototypeCard {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getCard() {
        System.out.println("Esto es una tarjeta MasterCard");
    }

    @Override
    public PrototypeCard clone() throws CloneNotSupportedException {
        System.out.println("Clonando tarjeta MasterCard...");
        return (Mastercard) super.clone();
    }
}

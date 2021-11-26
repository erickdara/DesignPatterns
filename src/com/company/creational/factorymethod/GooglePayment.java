package com.company.creational.factorymethod;

public class GooglePayment implements Payment{
    @Override
    public void doPayment() {
        System.out.println("Pagando con google Payment");
    }
}

package com.company.creational.abstractfactory;

public class Mastercard implements Card {
    @Override
    public String getCardType() {
        return "MASTERCARD";
    }

    @Override
    public String getCardNumber() {
        return "0000 0000 0000 MASTERCARD";
    }
}

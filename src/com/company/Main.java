package com.company;

import com.company.creational.factorymethod.Payment;
import com.company.creational.factorymethod.PaymentFactory;
import com.company.creational.factorymethod.TypePayment;
import com.company.creational.abstractfactory.AbstractFactory;
import com.company.creational.abstractfactory.Card;
import com.company.creational.abstractfactory.FactoryProvider;
import com.company.creational.abstractfactory.PaymentMethod;

public class Main {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card card = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("CREDIT");

        System.out.println("Un tarjeta de tipo = " + card.getCardType() + " con el método de pago: " + paymentMethod.doPayment());
    }

    //Probar método testFactoryMethod();
    private static void testFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }
}

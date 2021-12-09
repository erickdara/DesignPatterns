package com.company;

import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDesactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.creational.factorymethod.Payment;
import com.company.creational.factorymethod.PaymentFactory;
import com.company.creational.factorymethod.TypePayment;
import com.company.creational.abstractfactory.AbstractFactory;
import com.company.creational.abstractfactory.Card;
import com.company.creational.abstractfactory.FactoryProvider;
import com.company.creational.abstractfactory.PaymentMethod;
import com.company.creational.prototype.PrototypeCard;
import com.company.creational.prototype.PrototypeFactory;

import static com.company.creational.prototype.PrototypeFactory.CardType.MASTERCARD;
import static com.company.creational.prototype.PrototypeFactory.CardType.VISA;

public class Main {

    public static void main(String[] args) {

        //CREACIONALES
        //testFactoryMethod();
        //testAbstractFactory();
        //testBuilder();
        //testPrototype();
        //testSingleton();

        //COMPORTAMIENTO
        //testChainOfResponsability();
        testCommand();
    }

    private static void testCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCard1 = new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("-----------------------------");
        invoker.setCommand(new CreditCardDesactivateCommand(creditCard1));
        invoker.run();
    }

    private static void testChainOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(2000);
    }

    private static void testSingleton() {
        com.company.creational.singleton.Card.getINSTANCE().setCardNumber("9876-1234-5678");
        System.out.println(com.company.creational.singleton.Card.getINSTANCE().getCardNumber());
    }

    private static void testPrototype() {
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();

            PrototypeCard mastercard = PrototypeFactory.getInstance(MASTERCARD);
            mastercard.getCard();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    private static void testBuilder(){
        com.company.creational.builder.Card card = new com.company.creational.builder.Card.CardBuilder("VISA",
                "0000 1111 2222 3333")
                .name("Erick Rangel")
                .expires(2050)
                .build();

        System.out.println("card = " + card);

        com.company.creational.builder.Card card1 = new com.company.creational.builder.Card.CardBuilder("MASTERCARD",
                " 9999 7777 8888 6666")
                .build();

        System.out.println("card1 = " + card1);

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

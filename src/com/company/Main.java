package com.company;

import com.company.behavioral.chainofresponsability.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDeactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.behavioral.iterator.CardList;
import com.company.behavioral.iterator.Iterator;
import com.company.behavioral.iterator.List;
import com.company.behavioral.mediator.ConcreteColleage1;
import com.company.behavioral.mediator.ConcreteColleage2;
import com.company.behavioral.mediator.ConcreteMediator;
import com.company.behavioral.memento.Article;
import com.company.behavioral.memento.ArticleMemento;
import com.company.behavioral.memento.Carataker;
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
        //testCommand();
        //testIterator();
        //testMediator();
        testMemento();

    }

    private static void testMemento(){
        Carataker carataker = new Carataker();
        Article article = new Article("Erick", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());
        article.setText(article.getText() + " protagonizado por Guy Pearce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());

        article.setText(article.getText() + " y Leonardo di Caprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println();

        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + " del a??o 2021");
        System.out.println(article.getText());
    }

    private static void testMediator(){
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user 1");
        user2.send("Hola user1, soy user2");

    }

    private static void testIterator(){
        com.company.behavioral.iterator.Card[] cards = new com.company.behavioral.iterator.Card[5];
        cards[0] = new com.company.behavioral.iterator.Card("VISA");
        cards[1] = new com.company.behavioral.iterator.Card("MASTERCARD");
        cards[2] = new com.company.behavioral.iterator.Card("AMEX");
        cards[3] = new com.company.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new com.company.behavioral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);
        Iterator iterator = lista.iterator();

        while (iterator.hasNext()){
            com.company.behavioral.iterator.Card tarjeta= (com.company.behavioral.iterator.Card)iterator.next();
            System.out.println(tarjeta.getType());
        }
        
    }

    private static void testCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCard1 = new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("-----------------------------");
        invoker.setCommand(new CreditCardDeactivateCommand(creditCard1));
        invoker.run();
    }

    private static void testChainOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(100000);
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

        System.out.println("Un tarjeta de tipo = " + card.getCardType() + " con el m??todo de pago: " + paymentMethod.doPayment());
    }

    //Probar m??todo testFactoryMethod();
    private static void testFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }
}

package com.company.behavioral.mediator;

public class ConcreteColleage2 extends Colleage{

    public ConcreteColleage2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }

    @Override
    public void messageReceived(String message) {
        System.out.println("Colleage 2 ha recibido el siguiente mensaje: " + message);
    }
}

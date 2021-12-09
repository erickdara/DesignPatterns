package com.company.behavioral.command;

public class CreditCard {

    public void sendPinNumberToCustomer(){
        System.out.println("El pin number ha sido enviado al cliente.");
    }
    public void sendSMSToCustomerActivate(){
        System.out.println("Enviado SMS al cliente informando que su tarjeta ha sido activada. Ponte en contacto si no la has recibido");
    }
    public void activate(){
        System.out.println("La tarjeta ha sido activada.");
    }
    public void desactivate(){
        System.out.println("La tarjeta ha sido desactivada.");
    }
    public void sendSMSToCustomerDesactivate(){
        System.out.println("Enviando SMS al cliente informando que su tarjeta ha sido desactivada.");
    }


}

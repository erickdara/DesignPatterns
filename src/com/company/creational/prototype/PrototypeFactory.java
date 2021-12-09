package com.company.creational.prototype;

import java.util.HashMap;
import java.util.Map;

import static com.company.creational.prototype.PrototypeFactory.CardType.MASTERCARD;
import static com.company.creational.prototype.PrototypeFactory.CardType.VISA;

public class PrototypeFactory {

    public static class CardType{
        public static final String VISA = "visa";
        public static final String MASTERCARD = "mastercard";
    }

    private static Map<String, PrototypeCard> prototypes = new HashMap<>();

    public static PrototypeCard getInstance(final String tipo) throws CloneNotSupportedException{
        return prototypes.get(tipo).clone();
    }

    //El objetivo de utilizar el patron prototype es para esos objetos que van a demandar mucha memoria
    //y cuesta mucho tiempo crearlos y es una forma mas ficiente ya que clonarlos es una forma mucho mas
    //rapido que crearlo.
    public static void loadCard(){
        Visa visa = new Visa();
        visa.setName("Esta tarjeta es Visa con numero 1234");
        prototypes.put(VISA, visa);

        Mastercard mastercard = new Mastercard();
        mastercard.setName("Esta tarjeta es Mastercard con numero 9876");
        prototypes.put(MASTERCARD, mastercard);
    }


}

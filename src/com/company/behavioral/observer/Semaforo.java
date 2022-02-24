package com.company.behavioral.observer;

public class Semaforo {
    public String status;

    public Semaforo (String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}

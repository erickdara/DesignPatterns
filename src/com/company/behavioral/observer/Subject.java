package com.company.behavioral.observer;

public interface Subject {
    void attach(Observer o);
    void dettach (Observer o);
    void notifyUpdate(Semaforo semaforo);
}

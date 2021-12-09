package com.company.behavioral.chainofresponsability;

public class Gold implements ApproveLoanChain{

    private ApproveLoanChain next;

    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void creditCardRequest(int totalLoan) {
        if(totalLoan <= 1000){
            System.out.println("Esta solicitud de tarjeta de crédito la maneja la tarjeta Gold");
        } else {
            next.creditCardRequest(totalLoan);
        }
    }
}

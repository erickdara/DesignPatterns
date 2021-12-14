package com.company.behavioral.command;

public class CreditCardDeactivateCommand implements Command{

    CreditCard creditCard;
    public CreditCardDeactivateCommand(CreditCard creditCard){
        this.creditCard = creditCard;
    }

    @Override
    public void execute() {
        creditCard.deactivate();
        creditCard.sendSMSToCustomerDeactivate();
    }
}

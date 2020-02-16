package com.lt.bit.IbanValidator.validation;

public class Iban {

    private String iban;
    boolean ibanValid;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public boolean isIbanValid() {
        return ibanValid;
    }

    public void setIbanValid(boolean ibanValid) {
        this.ibanValid = ibanValid;
    }
}


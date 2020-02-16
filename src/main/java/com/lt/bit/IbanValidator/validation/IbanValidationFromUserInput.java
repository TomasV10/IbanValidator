package com.lt.bit.IbanValidator.validation;

import java.io.IOException;

class IbanValidationFromUserInput {
    private IbanReadingTypeSelector ibanReadingTypeSelector = new IbanReadingTypeSelector();

    void readingIbanWrittenByHand() throws IOException {
        while (true) {
            System.out.println("For IBAN validation please write IBAN and press enter. Write 'exit' to quit application or 'back' - return to start");
            String iban = ibanReadingTypeSelector.scanner.nextLine();
            if (returnToStartOrQuitApp(iban)) break;
            System.out.println(iban + " " + IbanValidator.validateIBAN(iban));
        }
    }
    private boolean returnToStartOrQuitApp(String iban) throws IOException {
        if (iban.equals("exit")) {
            return true;
        } else if (iban.equals("back")) {
            ibanReadingTypeSelector.writeIbanOrReadFromFile();
            return true;
        }
        return false;
    }
}

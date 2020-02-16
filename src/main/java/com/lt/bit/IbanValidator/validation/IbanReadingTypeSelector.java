package com.lt.bit.IbanValidator.validation;

import java.io.IOException;
import java.util.Scanner;

public class IbanReadingTypeSelector {
    Scanner scanner;

    public IbanReadingTypeSelector() {
        this.scanner = new Scanner(System.in);
    }

    public void writeIbanOrReadFromFile() throws IOException {
        System.out.println("Choose IBAN reading type: write '1' - write down IBAN by yourself; '2' - reading IBANS from file");
        int selection = scanner.nextInt();
        boolean validSelection = false;
        while(!validSelection){
            switch (selection){
                case 1:
                    IbanValidationFromUserInput ibanValidationFromUserInput = new IbanValidationFromUserInput();
                    ibanValidationFromUserInput.readingIbanWrittenByHand();
                    validSelection = true;
                    break;
                case 2:
                    IbanValidationFromFile ibanValidationFromFile = new IbanValidationFromFile();
                    ibanValidationFromFile.readingFromFile();
                    validSelection = true;
                    break;
                default:
                    throw new RuntimeException("Something went wrong. Check the input");
            }
        }
    }
}

package com.lt.bit.IbanValidator.validation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IbanValidationFromFile {
        private IbanReadingTypeSelector ibanReadingTypeSelector = new IbanReadingTypeSelector();
        private List<String> ibans;

    void readingFromFile() throws IOException {
        while(true){
            System.out.println("Enter full path and name of the file. Write 'exit' to quit application or 'back' - return to start");
            String fileName = ibanReadingTypeSelector.scanner.nextLine();
            if (returnToStartOrQuitApp(fileName)) break;
            try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                ibans = lines.collect(Collectors.toList());
                PrintWriter out = new PrintWriter(new FileWriter(fileName.substring(0, fileName.indexOf(".")) + ".out"));
                ibans.forEach(iban ->
                        out.println(iban + ";" + IbanValidator.validateIBAN(iban)));
                out.close();
            }
        }
    }

    private boolean returnToStartOrQuitApp(String fileName) throws IOException {
        if(fileName.equals("exit")){
            return true;
        }else if (fileName.equals("back")){
            ibanReadingTypeSelector.writeIbanOrReadFromFile();
            return true;
        }
        return false;
    }

    public List<String> getIbans() {
        return ibans;
    }

    public void setIbans(List<String> ibans) {
        this.ibans = ibans;
    }
}

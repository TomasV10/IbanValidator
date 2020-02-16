package com.lt.bit.IbanValidator.validation;

import java.math.BigInteger;
import java.util.Locale;

public class IbanValidator {

   public static boolean validateIBAN(String ibanNum) {

       String ibanNumber = ibanNum.replaceAll("\\s", "").toUpperCase(Locale.ROOT);
       if (checkLenghtAndSymbols(ibanNumber)) return false;
       ibanNumber = ibanNumber.substring(4) + ibanNumber.substring(0, 4);
       StringBuilder sb = convertToInteger(ibanNumber);
       return checkRemainder(sb);

    }

    private static boolean checkRemainder(StringBuilder sb) {
        BigInteger bigInt = new BigInteger(sb.toString());
        return bigInt.mod(BigInteger.valueOf(97)).intValue() == 1;
    }

    private static StringBuilder convertToInteger(String ibanNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ibanNumber.length(); i++)
            sb.append(Character.digit(ibanNumber.charAt(i), 36));
        return sb;
    }

    private static boolean checkLenghtAndSymbols(String ibanNumber) {
        return ibanNumber.length() < 4 || !ibanNumber.matches("[0-9A-Z]+") ||
                Fixtures.DEFINITIONS.getOrDefault(ibanNumber.substring(0, 2), 0) != ibanNumber.length();
    }
}

package com.lt.bit.IbanValidator.controllers;

import com.lt.bit.IbanValidator.validation.Iban;
import com.lt.bit.IbanValidator.validation.IbanValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IbanController {

    @PostMapping("/ibans")
    public ResponseEntity<List<Iban>>getAllIbans(@RequestBody List<Iban>ibans){
        ibans.forEach(iban -> iban.setIbanValid(IbanValidator.validateIBAN(iban.getIban())));
        return new ResponseEntity<List<Iban>>(ibans, HttpStatus.OK);
    }


}

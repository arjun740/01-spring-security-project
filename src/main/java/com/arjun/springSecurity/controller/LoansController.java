package com.arjun.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/myLoan")
    public String getAccountDetails(){
        return "Loan Detail From DB";
    }

}

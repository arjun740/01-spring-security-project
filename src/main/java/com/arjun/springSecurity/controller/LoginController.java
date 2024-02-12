package com.arjun.springSecurity.controller;

import com.arjun.springSecurity.model.Customer;
import com.arjun.springSecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Customer customer){
        Customer savedCustomer;
        System.out.println(customer);
        ResponseEntity response  = null;
        try{
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() > 0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("the given detail are registered successfully");
            }
        }
        catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The Exception Occured due to "+ e.getMessage());
        }
        return response;
    }

}

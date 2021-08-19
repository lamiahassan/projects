package com.example.phoneNumbers.restapi.controller;

import java.util.List;

import com.example.phoneNumbers.models.Customer;
import com.example.phoneNumbers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hassanle
 */

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/customers")
public class CustomerController {

   @Autowired
   private CustomerService customerService;


   @GetMapping("/all")

   public ResponseEntity<List<Customer>> allCustomersPhones(){
      return new ResponseEntity<>((List<Customer>) customerService.findAll(),HttpStatus.OK);
   }

}

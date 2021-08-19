package com.example.phoneNumbers.restapi.controller;

import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import com.example.phoneNumbers.services.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hassanle
 */

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/customerData")
public class CustomerDataController {

   @Autowired
   private CustomerDataService customerDataService;

   @GetMapping("/findByCountry")
   public ResponseEntity<List<CustomerData>> getAllPhonesByCountry(@RequestParam String country) {
      return new ResponseEntity<>(customerDataService.findAllByCountry(country), HttpStatus.OK);
   }

   @GetMapping("/findByState")
   public ResponseEntity<List<CustomerData>> getAllPhonesByState(@RequestParam boolean state) {
      return new ResponseEntity<>(customerDataService.findAllByState(state), HttpStatus.OK);
   }

   @GetMapping("/all")
   public ResponseEntity<Iterable<CustomerData>> getAll() {
      return new ResponseEntity<>(customerDataService.findAll(), HttpStatus.OK);
   }

   @GetMapping("/allPages")
   public ResponseEntity<List<CustomerData>> getAllCustomerData(@RequestParam Integer pageNo,
                                                                @RequestParam Integer pageSize) {
      List<CustomerData> customerDataList = customerDataService.getAllCustomersData(pageNo, pageSize);
      return new ResponseEntity<>(customerDataList, HttpStatus.OK);
   }

   @GetMapping("/validatePhonesState")
   public ResponseEntity<List<CustomerData>> updateAllPhonesState() {
      return new ResponseEntity<>((List<CustomerData>) customerDataService.updateAllPhonesState(), HttpStatus.OK);
   }
}

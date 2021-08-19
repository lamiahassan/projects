package com.example.phoneNumbers.services.impl;

import com.example.phoneNumbers.models.Customer;
import com.example.phoneNumbers.repositories.CustomerRepository;
import com.example.phoneNumbers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author hassanle
 */
@Service
@Validated
public class CustomerServiceImpl implements CustomerService {
   @Autowired
   private CustomerRepository customerRepository;

   @Override
   public Iterable<Customer> findAll() {
      return customerRepository.findAll();
   }
}

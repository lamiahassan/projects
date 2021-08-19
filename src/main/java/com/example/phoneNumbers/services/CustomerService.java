package com.example.phoneNumbers.services;

import com.example.phoneNumbers.models.Customer;

/**
 * @author hassanle
 */
public interface CustomerService {

   Iterable<Customer> findAll();
}

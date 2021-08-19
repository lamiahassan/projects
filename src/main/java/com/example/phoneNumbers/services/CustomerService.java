/*
 * Copyright (c) Dematic GmbH 2021. All rights reserved. Confidential.
 */
package com.example.phoneNumbers.services;

import com.example.phoneNumbers.models.Customer;

/**
 * @author hassanle
 */
public interface CustomerService {

   Iterable<Customer> findAll();
}

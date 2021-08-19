package com.example.phoneNumbers.repositories;

import java.util.Optional;

import com.example.phoneNumbers.models.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hassanle
 */

public interface CustomerRepository extends CrudRepository<Customer,Integer>{
   @Override
   Optional<Customer> findById(Integer integer);

}

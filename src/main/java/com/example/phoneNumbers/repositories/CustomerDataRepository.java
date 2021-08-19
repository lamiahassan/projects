package com.example.phoneNumbers.repositories;

import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hassanle
 */
@Repository
public interface CustomerDataRepository
      extends CrudRepository<CustomerData, Integer>, PagingAndSortingRepository<CustomerData, Integer> {

   List<CustomerData> findAllByCountry(String country);

   List<CustomerData> findAllByState(boolean state);
}

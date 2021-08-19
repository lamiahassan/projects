package com.example.phoneNumbers.services;

import java.util.List;
import com.example.phoneNumbers.models.CustomerData;

/**
 * @author hassanle
 */
public interface CustomerDataService {

   List<CustomerData> findAllByCountry(String country);
   List<CustomerData> findAllByState(boolean state);
   Iterable<CustomerData> updateAllPhonesState();
   List<CustomerData> getAllCustomersData(Integer pageNo,Integer pageSize);
   Iterable<CustomerData> findAll();

}

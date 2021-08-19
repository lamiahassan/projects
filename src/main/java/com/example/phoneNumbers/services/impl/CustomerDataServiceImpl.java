package com.example.phoneNumbers.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import com.example.phoneNumbers.repositories.CustomerDataRepository;
import com.example.phoneNumbers.restapi.validator.Validator;
import com.example.phoneNumbers.services.CustomerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * @author hassanle
 */
@Service
@Validated
public class CustomerDataServiceImpl implements CustomerDataService {

   @Autowired
   Validator validator;

   @Autowired
   CustomerDataRepository customerDataRepository;

   @Override
   public List<CustomerData> findAllByCountry(String country) {
      return customerDataRepository.findAllByCountry(country);
   }

   @Override
   public List<CustomerData> findAllByState(boolean state) {
      return customerDataRepository.findAllByState(state);
   }

   @Override
   public Iterable<CustomerData> findAll(){return  customerDataRepository.findAll();}

   @Override
   public List<CustomerData> getAllCustomersData(Integer pageNo, Integer pageSize) {
      Pageable paging = PageRequest.of(pageNo, pageSize);
      Page<CustomerData> pagedResult = customerDataRepository.findAll(paging);
      return pagedResult.getContent();
   }

   @Override
   @Transactional(rollbackFor = Exception.class)
   public Iterable<CustomerData> updateAllPhonesState() {
      List<CustomerData> customerDataUpdatedList = new ArrayList<>();
      Iterable<CustomerData> customerData = customerDataRepository.findAll();
      customerDataUpdatedList = validator.validatePhones((List<CustomerData>) customerData);
      customerDataRepository.saveAll(customerDataUpdatedList);
      return customerDataUpdatedList;
   }
}

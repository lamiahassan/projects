package com.example.phoneNumbers.restapi.validator;

import java.util.ArrayList;
import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author hassanle
 */

@Configuration
@Component
public class Validator {

  @Value("${country.Cameroon}")
   private String camerooonRegex;

   @Value("${country.Ethiopia}")
   private String ethiopoaRegex;

   @Value("${country.Morocco}")
   private String moroccoRegex;

   @Value("${country.Mozambique}")
   private String mozambiqueRegex;

   @Value("${country.Uganda}")
   private String ugandaRegex;

   public List<CustomerData> validatePhones(List<CustomerData> customerDataList) {

      String currentPhoneCode, currentCountryRegex, phoneNumber = null;
      boolean phoneValid = false;
      List<CustomerData> customerDataUpdatedList = new ArrayList<>();

      for (CustomerData customerData : customerDataList) {
         currentPhoneCode = customerData.getPhoneNo().substring(1,4);
         currentCountryRegex = getRegex(currentPhoneCode);
         phoneNumber = customerData.getPhoneNo();
         phoneValid = phoneNumber.matches(currentCountryRegex);
         customerData.setState(phoneValid);
         customerDataUpdatedList.add(customerData);
      }
      return customerDataList;
   }


   public String getRegex(String phoneCode) {
      String currentCountryRegex = null;

      switch (phoneCode) {
         case "237":
            currentCountryRegex = camerooonRegex;
            break;
         case "251":
            currentCountryRegex = ethiopoaRegex;
            break;
         case "212":
            currentCountryRegex = moroccoRegex;
            break;
         case "258":
            currentCountryRegex = mozambiqueRegex;
            break;
         case "256":
            currentCountryRegex = ugandaRegex;
            break;
      }
      return currentCountryRegex;
   }
}

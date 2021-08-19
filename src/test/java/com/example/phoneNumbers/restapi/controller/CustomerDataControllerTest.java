package com.example.phoneNumbers.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import com.example.phoneNumbers.repositories.CustomerDataRepository;
import com.example.phoneNumbers.services.CustomerDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDataControllerTest {

   private MockMvc mockMvc;
   @MockBean
   private CustomerDataController customerDataController;

   @MockBean
   CustomerDataService customerDataService;

   @MockBean
   CustomerDataRepository customerDataRepository;

   @Before
   public void setup() throws Exception {
      mockMvc = MockMvcBuilders.standaloneSetup(customerDataController).build();
   }

   @Test
   public void getAllCustomersData_success() throws Exception {

      List<CustomerData> customerDataList = new ArrayList<>();
      customerDataList.add(CustomerData.builder().custId(1).phoneNo("3333").country("test").state(false).build());
      Mockito.when(customerDataRepository.findAll()).thenReturn(customerDataList);

      mockMvc.perform(MockMvcRequestBuilders
            .get("/customerData/all")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
   }
}
package com.example.phoneNumbers.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.example.phoneNumbers.models.CustomerData;
import com.example.phoneNumbers.repositories.CustomerDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDataServiceTest {

   private MockMvc mockMvc;

   @MockBean
   CustomerDataService customerDataService;

   @MockBean
   CustomerDataRepository customerDataRepository;

   @Before
   public void setup() throws Exception {
      mockMvc = MockMvcBuilders.standaloneSetup(customerDataService).build();
   }

   @Test
   public void findAll() {
      List<CustomerData> customerDataList = new ArrayList<>();
      customerDataList.add(CustomerData.builder().custId(1).phoneNo("3333").country("lamia").state(false).build());
      customerDataList.add(CustomerData.builder().custId(2).phoneNo("1111").country("hassan").state(true).build());

      Mockito.when(customerDataService.findAll()).thenReturn(customerDataList);
      assertEquals(customerDataList , customerDataService.findAll());

   }
}
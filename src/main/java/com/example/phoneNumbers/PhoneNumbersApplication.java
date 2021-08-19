package com.example.phoneNumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PhoneNumbersApplication {

   public static void main(String[] args) {
      SpringApplication.run(PhoneNumbersApplication.class, args);
   }
}

/*
 * Copyright (c) Dematic GmbH 2021. All rights reserved. Confidential.
 */
package com.example.phoneNumbers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hassanle
 */
@Table(name = "CUSTOMERDATA")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerData
{
   @Id
   @Column(name = "PHONE_NO")
   private String phoneNo ;

   @Column(name = "COUNTRY")
   private String country;

   @Column(name = "STATE")
   private boolean state;

   @Column(name = "CUST_ID")
   private int custId;


}

package com.example.phoneNumbers.models;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hassanle
 */
@Table(name = "customer")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
   @Id
   @Column(name = "ID")
   private int id;

   @Column(name = "NAME")
   private String name;


   @OneToMany (mappedBy = "custId")
   private Set <CustomerData> customerDataset;


}

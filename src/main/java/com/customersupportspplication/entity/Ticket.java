package com.customersupportspplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String subject;
   private String description;
   private String email;   // Customer email for reference
   private String status;  // e.g. Open, In Progress, Closed
}

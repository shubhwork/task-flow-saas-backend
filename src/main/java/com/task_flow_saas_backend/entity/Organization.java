package com.task_flow_saas_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Organization {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
}

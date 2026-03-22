package com.sna.practice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long   id;
    private String street;
    private String city;
    private String country;
}
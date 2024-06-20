package com.example.hungerbox.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;
    private String name;
    private String location;
    private Integer rating;
    private String[] reviews;


}

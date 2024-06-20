package com.example.hungerbox.service;


import com.example.hungerbox.model.Restaurant;
import com.example.hungerbox.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // get all restaurants in my city

    public List<Restaurant> getAllRestaurants(){
        return this.restaurantRepository.findAll();
    }



    // add new restaurant to the application

    public String addNewRestaurant(Restaurant newRestaurant){
        this.restaurantRepository.save(newRestaurant);
        return "restaurant added successfully";
    }



    // update

    public String updateRestaurant(Integer restaurantId,Restaurant updatedRestaurant){

               Restaurant existingRestaurant = this.restaurantRepository.findById(restaurantId).get();

               existingRestaurant.setName(updatedRestaurant.getName());
               existingRestaurant.setLocation(updatedRestaurant.getLocation());
               existingRestaurant.setRating(updatedRestaurant.getRating());
               existingRestaurant.setReviews(updatedRestaurant.getReviews());
               this.restaurantRepository.save(existingRestaurant);

               return "updated details successfully";

    }


    //delete


    public void deleteRestaurant(Integer restaurantId){
        this.restaurantRepository.deleteById(restaurantId);

    }


    // get single restaurant

    public Restaurant getMyRestaurantDetails(Integer restaurantId){
        return this.restaurantRepository.findById(restaurantId).get();
    }

    // partial update

    public Restaurant updateName(Integer restaurantId,String updatedName){
        Restaurant existingRestaurant = this.restaurantRepository.findById(restaurantId).get();
        existingRestaurant.setName(updatedName);
        this.restaurantRepository.save(existingRestaurant);
        return existingRestaurant;
    }


}

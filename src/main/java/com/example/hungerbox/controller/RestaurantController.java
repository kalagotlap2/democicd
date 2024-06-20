package com.example.hungerbox.controller;

import com.example.hungerbox.model.Restaurant;
import com.example.hungerbox.service.RestaurantService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/all")
//    @OpenAPIDefinition(@Description = "this api should provide all the restaurants available in the database")
    public List<Restaurant> getAllRestaurants(){
        return this.restaurantService.getAllRestaurants();
    }



    @PostMapping("/add")
    @Operation(summary = "add a new restaurant", description = "add a new restaurant details to the database")
    public String addNewRestaurant(@RequestBody Restaurant newRestaurant){
        return this.restaurantService.addNewRestaurant(newRestaurant);
    }



    @PutMapping("/update/{restaurantId}")
    @Operation(summary = "add a new restaurant", description = "add a new restaurant details to the database")
    public String updateRestaurant(@PathVariable Integer restaurantId,@RequestBody Restaurant updatedRestaurant){

        return this.restaurantService.updateRestaurant(restaurantId,updatedRestaurant);
    }


    @GetMapping("/restaurant/{myrestaurantId}")
    public Restaurant getSingleRestaurantDetails(@PathVariable Integer myrestaurantId){
        return this.restaurantService.getMyRestaurantDetails(myrestaurantId);

    }


    @DeleteMapping("/delete/{restaurantId}")
    public void deleteRestaurant(@PathVariable Integer restaurantId){
         this.restaurantService.deleteRestaurant(restaurantId);
    }


    @PatchMapping("/updatename/{restaurantId}/{name}")
    public Restaurant updateNameOfTheRestaurant(@PathVariable Integer restaurantId,@PathVariable String name){
        return this.restaurantService.updateName(restaurantId,name);
    }
}

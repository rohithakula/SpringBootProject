package com.example.Foodorderapp.controllers;


import com.example.Foodorderapp.authExceptions.AuthorizationExceptions;
import com.example.Foodorderapp.authServices.UserService;
import com.example.Foodorderapp.exceptions.RestaurantException;
import com.example.Foodorderapp.model.Restaurant;
import com.example.Foodorderapp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/restaurant"})
public class RestaurantServiceController {

    RestaurantService restaurantService;

    UserService userService;

    @PostMapping({"/add"})
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
        Restaurant addRestaurant = this.restaurantService.addRestaurant(restaurant);
        return new ResponseEntity(addRestaurant, HttpStatus.CREATED);
    }
    @PutMapping({"/update"})
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
        Restaurant updateRestaurant = this.restaurantService.updateRestaurant(restaurant);
        return  new ResponseEntity(updateRestaurant,HttpStatus.ACCEPTED);
    }

    @DeleteMapping({"/remove/{restaurantId}"})
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
        Restaurant deleteRestaurant = this.restaurantService.removeRestaurant(restaurantId);
        return  new ResponseEntity(deleteRestaurant,HttpStatus.OK);
    }

    @GetMapping({"/view/{restaurantId}"})
    public ResponseEntity<Restaurant> viewRestaurant(@PathVariable("restaurantId") Integer restaurantId,@RequestParam String Key) throws RestaurantException, AuthorizationExceptions{

        Integer sessionId = userService.getUserSessionId(Key);
        if (sessionId!=null){
            Restaurant viewRestaurant = this.restaurantService.viewRestaurant(restaurantId);
            return new ResponseEntity(viewRestaurant,HttpStatus.OK);
        }else{
            throw new RestaurantException(" ");
        }
    }


}

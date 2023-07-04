package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.RestaurantException;
import com.example.Foodorderapp.model.Restaurant;
import com.example.Foodorderapp.repositories.RestaurantDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantDAO restaurantDAO;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
        Optional<Restaurant> optionalRestaurant = this.restaurantDAO.findById(restaurant.getRestaurantId());
        if (optionalRestaurant.isPresent()){
            throw new RestaurantException("Restaurant already exists");
        }else{
            return restaurantDAO.save(restaurant);
        }
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
        Optional<Restaurant> optionalRestaurant = this.restaurantDAO.findById(restaurant.getRestaurantId());
        if (optionalRestaurant.isPresent()){
            return(Restaurant)this.restaurantDAO.save(restaurant);
        }else {
            throw new RestaurantException("Restaurant not found..");
        }
    }

    @Override
    public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
        Optional<Restaurant> optionalRestaurant = this.restaurantDAO.findById(restaurantId);
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            this.restaurantDAO.delete(restaurant);
            return restaurant;
        }else{
            throw new RestaurantException("Restaurant not found by Id: " + restaurantId);
        }
    }

    @Override
    public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
        Optional<Restaurant> optionalRestaurant = this.restaurantDAO.findById(restaurantId);
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            return restaurantDAO.save(restaurant);
        }else{
            throw new RestaurantException("Restaurant nt found with Id: " + restaurantId);
        }

    }
}

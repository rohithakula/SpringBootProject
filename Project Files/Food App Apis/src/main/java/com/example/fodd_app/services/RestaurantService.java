package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.RestaurantException;
import com.example.Foodorderapp.model.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException;
    Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException;
    Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException;
    Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException;

}

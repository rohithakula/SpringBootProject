package com.example.fodd_app.services;

import java.util.List;

import com.example.fodd_app.payloads.ApiResponses;
import com.example.fodd_app.payloads.FoodDto;

public interface FoodService {

    FoodDto createFood(FoodDto food);
    FoodDto updateFood(FoodDto foodDto, Integer id);
    FoodDto getFood(Integer id);
    List<FoodDto> getAllFood();
    void deleteFood(Integer id);


}

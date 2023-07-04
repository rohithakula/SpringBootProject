package com.example.fodd_app.services.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import com.example.fodd_app.payloads.ApiResponses;
import com.example.fodd_app.payloads.FoodDto;
import com.example.fodd_app.repositories.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fodd_app.entities.Food;
import com.example.fodd_app.services.FoodService;
import com.example.fodd_app.exceptions.ResourceNotFoundException;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepo foodRepo;

    @Override
    public FoodDto createFood(FoodDto foodDto) {
        // TODO Auto-generated method stub

        Food food = this.dtoToFood(foodDto);

        Food savedFood = this.foodRepo.save(food);
        return this.foodToDto(savedFood);
    }

    @Override
    public FoodDto updateFood(FoodDto foodDto, Integer fid) {
        // TODO Auto-generated method stub
        Food food = this.foodRepo.findById(fid)
                .orElseThrow(() -> new ResourceNotFoundException("user","id",fid));
        food.setName(foodDto.getName());
        food.setHotel(foodDto.getHotel());
        food.setPrice(foodDto.getPrice());

        Food updateFood = this.foodRepo.save(food);
        FoodDto foodDto1 = this.foodToDto(updateFood);

        return foodDto1;
    }

    @Override
    public FoodDto getFood(Integer id) {
        // TODO Auto-generated method stub
        Food food = this.foodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user","id",id));

        return this.foodToDto(food);
    }

    @Override
    public List<FoodDto> getAllFood() {
        // TODO Auto-generated method stub
        List<Food> foods = this.foodRepo.findAll();

        List<FoodDto> foodDtos = foods.stream().map(food -> this.foodToDto(food)).collect(Collectors.toList());

        return foodDtos;
    }

    @Override
    public void deleteFood(Integer id) {
        // TODO Auto-generated method stub

        Food food = this.foodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user","id",id));

        this.foodRepo.delete(food);

    }

    private Food dtoToFood(FoodDto foodDto) {

        Food food = new Food();
        food.setId(foodDto.getId());
        food.setName(foodDto.getName());
        food.setHotel(foodDto.getHotel());
        food.setPrice(foodDto.getPrice());

        return food;

    }

    public FoodDto foodToDto(Food food) {

        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setHotel(food.getHotel());
        foodDto.setPrice(food.getPrice());

        return foodDto;
    }
}

package com.example.fodd_app.controllers;

import com.example.fodd_app.payloads.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fodd_app.services.FoodService;

import com.example.fodd_app.payloads.ApiResponses;

import java.util.List;


@RestController
@RequestMapping("/api/v1/food/")
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodService foodService;

    //Post - Create Food
    @PostMapping("/fsave")
    public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto){
        FoodDto createFoodDto = this.foodService.createFood(foodDto);
        return new ResponseEntity<>(createFoodDto,HttpStatus.CREATED);
    }

    //Put - Update Food

    @PutMapping("/fput{id}")
    public ResponseEntity<FoodDto> updateFood(@RequestBody FoodDto foodDto,@PathVariable("id") Integer id){

        FoodDto updatedFood = this.foodService.updateFood(foodDto,id);
        return ResponseEntity.ok(updatedFood);
    }

    //Delete - delete food

    @DeleteMapping("/fdelete{id}")
    public ResponseEntity<ApiResponses> deleteFood(@PathVariable("id") Integer id){

        this.deleteFood(id);
        return new ResponseEntity<ApiResponses>(new ApiResponses("Food deleted successfull0y", true,id),HttpStatus.OK);
    }

    //Get - food list

    @GetMapping("/flist")
    public ResponseEntity<List<FoodDto>> getAllFood(){

        return ResponseEntity.ok(this.foodService.getAllFood());
    }

    // Get - food get

    @GetMapping("/fget{id}")
    public ResponseEntity<FoodDto> getSingleFood(@PathVariable Integer id){

        return ResponseEntity.ok(this.foodService.getFood(id));
    }

}

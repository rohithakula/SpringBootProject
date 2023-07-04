package com.example.fodd_app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Setter
@Getter
public class FoodDto {

    private int id;
    private String name;
    private String hotel;
    private int price;
}

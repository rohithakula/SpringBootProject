package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CartException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.FoodCart;

public interface FoodCartService {

    public FoodCart saveCart(FoodCart cart)throws CartException;

    public FoodCart addItem(Integer cartId, Integer itemId)throws CartException, ItemException;

    public FoodCart clearCart(Integer cartId)throws CartException;

    public FoodCart viewCart(Integer cartId)throws CartException;
}

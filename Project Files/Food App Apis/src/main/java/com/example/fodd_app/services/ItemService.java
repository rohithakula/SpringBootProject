package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item)throws ItemException;

    public Item updateItem(Item item)throws ItemException;

    public Item viewItem(Integer itemId)throws ItemException;

    public Item removeItem(Integer itemId)throws ItemException;

    public List<Item> viewAllItems()throws ItemException;
}

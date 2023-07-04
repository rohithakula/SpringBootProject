package com.example.Foodorderapp.service;


import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.repositories.ItemDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    ItemDAO itemDAO;


    @Override
    public Item addItem(Item item) throws ItemException {
        Optional<Item> optionalItem = this.itemDAO.findById(item.getItemId());
        if (optionalItem.isPresent()){
            throw new ItemException("Item already exists..");
        }else{
            return this.itemDAO.save(item);
        }
    }

    @Override
    public Item updateItem(Item item) throws ItemException {
        Optional<Item> optionalItem = this.itemDAO.findById(item.getItemId());
        if (optionalItem.isPresent()){
            return(Item) this.itemDAO.save(item);
        }else{
            throw new ItemException("Item not found");
        }
    }

    @Override
    public Item viewItem(Integer itemId) throws ItemException {
        Optional<Item> optionalItem = this.itemDAO.findById(itemId);
        if (optionalItem.isPresent()){
            return optionalItem.get();
        }else{
            throw  new ItemException("Item not found by Id: " + itemId);
        }
    }

    @Override
    public Item removeItem(Integer itemId) throws ItemException {
        Optional<Item> optionalItem = this.itemDAO.findById(itemId);
        if (optionalItem.isPresent()){
            Item item = optionalItem.get();
            this.itemDAO.delete(item);
            return item;
        }else {
            throw new ItemException("No item exists..");
        }
    }

    @Override
    public List<Item> viewAllItems() throws ItemException {
        List<Item> itemList = (List<Item>) itemDAO.findAll();
        if (itemList.size()>0){
            return  itemList;
        }else{
            throw new ItemException("No item exists..");
        }

    }
}

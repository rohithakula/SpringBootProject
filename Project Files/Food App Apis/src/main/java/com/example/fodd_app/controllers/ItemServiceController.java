package com.example.Foodorderapp.controllers;


import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/item"})
public class ItemServiceController {



    ItemService itemService;


    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) throws ItemException {
        Item newItem = itemService.addItem(item);
        return new ResponseEntity<Item>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException{
        Item updatedItem = itemService.updateItem(item);
        return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
    }

    @GetMapping("/view/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("itemId") Integer itemId) throws ItemException{
        Item item = itemService.viewItem(itemId);
        return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Item> removeItem(@PathVariable("itemId") Integer itemId) throws ItemException{
        Item removedItem = itemService.removeItem(itemId);
        return new ResponseEntity<Item>(removedItem, HttpStatus.ACCEPTED);
    }


    @GetMapping("/viewAll")
    public ResponseEntity<List<Item>> getAllItems() throws ItemException{
        List<Item> items = itemService.viewAllItems();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

    }
}

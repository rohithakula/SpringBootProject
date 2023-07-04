package com.example.Foodorderapp.controllers;


import com.example.Foodorderapp.exceptions.CategoryException;
import com.example.Foodorderapp.model.Category;
import com.example.Foodorderapp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/category"})

public class CategoryServiceController {

    CategoryService categoryService;

    public CategoryServiceController(){

    }

    @PostMapping({"/add"})
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
        Category newcategory = this.categoryService.addCategory(category);
        return new ResponseEntity(newcategory, HttpStatus.CREATED);
    }

    @PutMapping({"/update"})
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
        Category updatedCategory = this.categoryService.updateCategory(category);
        return new ResponseEntity(updatedCategory,HttpStatus.ACCEPTED);
    }

    @DeleteMapping({"/remove{categoryId}"})
    public ResponseEntity<Category> removeCategory(@PathVariable("categoryId") Integer categoryId) throws  CategoryException{
        Category removeCategory= this.categoryService.removeCategory(categoryId);
        return new ResponseEntity(removeCategory,HttpStatus.ACCEPTED);
    }

    @GetMapping({"/view{categoryId}"})
    public ResponseEntity<Category> viewCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
        Category viewCategory = this.categoryService.viewCategory(categoryId);
        return new ResponseEntity(viewCategory,HttpStatus.OK);
    }

    @GetMapping({"/viewAll"})
    public ResponseEntity<List<Category>> viewAllCategory () throws CategoryException{
        List<Category> categoryList = categoryService.viewAllCategory();
        return new ResponseEntity(categoryList,HttpStatus.OK);

    }




}

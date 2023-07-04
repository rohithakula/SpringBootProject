package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CategoryException;
import com.example.Foodorderapp.model.Category;

import java.util.List;

public interface CategoryService {


    Category addCategory(Category category)throws CategoryException;

    Category updateCategory(Category category)throws CategoryException;

    Category viewCategory(Integer categoryId)throws CategoryException;

    Category removeCategory(Integer categoryId)throws CategoryException;

    List<Category> viewAllCategory()throws CategoryException;
}

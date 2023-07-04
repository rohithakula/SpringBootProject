package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CategoryException;
import com.example.Foodorderapp.model.Category;
import com.example.Foodorderapp.repositories.CategoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO;

    public CategoryServiceImpl(){

    }

    @Override
    public Category addCategory(Category category) throws CategoryException {
        Optional<Category> optionalCategory = this.categoryDAO.findById(category.getCategoryId());
        if (optionalCategory.isPresent()){
            throw new CategoryException("Category already exists..");
        }else{
            return(Category) this.categoryDAO.save(category);
        }
    }

    @Override
    public Category updateCategory(Category category) throws CategoryException {
        Optional<Category> optionalCategory = this.categoryDAO.findById(category.getCategoryId());
        if(optionalCategory.isPresent()){
           return this.categoryDAO.save(category);
        }else{
            throw new CategoryException("Category already exists..");
        }
    }

    @Override
    public Category viewCategory(Integer categoryId) throws CategoryException {
        Optional<Category> optionalCategory = this.categoryDAO.findById(categoryId);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else{
            throw new CategoryException("category is not found by: " + categoryId );
        }
    }

    @Override
    public Category removeCategory(Integer categoryId) throws CategoryException {
        Optional<Category> optionalCategory = this.categoryDAO.findById(categoryId);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            this.categoryDAO.delete(category);
            return category;
        }else{
            throw new CategoryException("Category is not found by: "+ categoryId);
        }
    }

    @Override
    public List<Category> viewAllCategory() throws CategoryException {
        List<Category> categoryList = (List<Category>) categoryDAO.findAll();
    if (categoryList.size()>0){
        return categoryList;
    }else{
        throw new CategoryException("Category not found..");
    }

    }
}

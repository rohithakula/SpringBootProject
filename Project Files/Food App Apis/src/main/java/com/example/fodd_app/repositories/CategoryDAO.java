package com.example.Foodorderapp.repositories;

import com.example.Foodorderapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface CategoryDAO extends CrudRepository<Category,Integer> {

}

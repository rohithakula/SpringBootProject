package com.example.fodd_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.Optional;
import com.example.fodd_app.entities.Food;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface FoodRepo extends JpaRepository<Food, Integer>{

    Optional<Food> findOneByNameAndHotel(String name, String hotel);
    Food findByName(String name);
    Food findByHotel(String hotel);
}

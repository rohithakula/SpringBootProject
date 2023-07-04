package com.example.Foodorderapp.repositories;

import com.example.Foodorderapp.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderDetailsDAO extends CrudRepository<OrderDetails,Integer> {

}

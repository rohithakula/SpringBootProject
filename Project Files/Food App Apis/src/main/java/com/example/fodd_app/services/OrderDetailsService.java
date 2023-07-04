package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.OrderException;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {


    OrderDetails addOrder(OrderDetails order) throws OrderException;
    OrderDetails updateOrder(OrderDetails order) throws  OrderException;
    OrderDetails removeOrder(Integer orderId) throws OrderException;
    OrderDetails viewOrder(Integer orderId) throws OrderException;
    List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException;
}

package com.example.Foodorderapp.service;


import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer)throws CustomerException;

    Customer updateCustomer(Customer customer)throws CustomerException;

    Customer removeCustomerById(Integer customerId)throws CustomerException;

    Customer viewCustomer(Integer customerId)throws CustomerException;

}

package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.model.Customer;
import com.example.Foodorderapp.repositories.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService{

    CustomerDAO customerDAO;

    public CustomerServiceImpl(){

    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        Optional<Customer> customerOptional = this.customerDAO.findById(customer.getCustomerId());
        if (customerOptional.isPresent()){
            throw new CustomerException("already exists..");
        }else{
            return this.customerDAO.save(customer);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
        Optional<Customer> optionalCustomer = this.customerDAO.findById(customer.getCustomerId());
        if(optionalCustomer.isPresent()){
            return(Customer) this.customerDAO.save(customer);
        }else{
            throw new CustomerException("Customer not found");
        }
    }

    @Override
    public Customer removeCustomerById(Integer customerId) throws CustomerException {
        Optional<Customer> optionalCustomer = this.customerDAO.findById(customerId);
        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            this.customerDAO.delete(customer);
            return customer;
        }else{
            throw new CustomerException("Customer not found..");
        }
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws CustomerException {
        Optional<Customer> optionalCustomer = this.customerDAO.findById(customerId);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else{
            throw new CustomerException("Customer not found by Id: "+ customerId);
        }
    }
}

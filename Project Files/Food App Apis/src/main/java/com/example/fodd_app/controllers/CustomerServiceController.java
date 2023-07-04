package com.example.Foodorderapp.controllers;

import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.model.Customer;
import com.example.Foodorderapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/customer"})

public class CustomerServiceController {

    public CustomerServiceController(){

    }
    CustomerService customerService;

    @PostMapping({"/add"})
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{
        Customer newCustomer = this.customerService.addCustomer(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @PutMapping({"/update"})
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
        Customer updateCustomer = this.customerService.updateCustomer(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @DeleteMapping({"/remove{customerId}"})
    public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
        Customer removeCustomer = this.customerService.removeCustomerById(customerId);
        return new ResponseEntity(customerId, HttpStatus.ACCEPTED);
    }

    @GetMapping({"/view{customerId}"})
    public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws  CustomerException{
        Customer viewCustomer = this.customerService.viewCustomer(customerId);
        return new ResponseEntity(customerId, HttpStatus.OK);
    }
}


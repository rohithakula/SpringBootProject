package com.example.Foodorderapp.controllers;

import com.example.Foodorderapp.authExceptions.AuthorizationExceptions;
import com.example.Foodorderapp.authServices.UserService;
import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.OrderException;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.model.OrderDetails;
import com.example.Foodorderapp.service.OrderDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/Order"})
public class OrderDetailsServiceController {
    OrderDetailsService orderDetailsService;
    UserService userService;

    @PostMapping({"/add"})
    public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order , @RequestParam String Key) throws OrderException, AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(Key);
        if (sessionId!=null){
            OrderDetails addOrder = this.orderDetailsService.addOrder(order);
            return new ResponseEntity(addOrder, HttpStatus.CREATED);
        }else{
            throw new OrderException();
        }
    }

    @PutMapping({"/update"})
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order , @RequestParam String key) throws OrderException,AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(key);
        if (userService!=null){
            return new ResponseEntity<OrderDetails>(orderDetailsService.updateOrder(order),HttpStatus.ACCEPTED);
        }else{
            throw new OrderException();
        }
    }

    @DeleteMapping({"/remove/{orderId}"})
    public ResponseEntity<OrderDetails> removeOrder(@PathVariable("orderId") Integer orderId , @RequestParam String Key) throws OrderException,AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(Key);
        if (sessionId!=null){
            return new ResponseEntity<OrderDetails>(orderDetailsService.removeOrder(orderId),HttpStatus.OK);
        }else{
            throw new OrderException();
        }
    }

    @GetMapping({"/view/{orderId}"})
    public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId,@RequestParam String Key) throws OrderException,AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(Key);
        if (sessionId!=null){
            return new ResponseEntity<OrderDetails>(orderDetailsService.viewOrder(orderId),HttpStatus.OK);
        }else {
            throw new OrderException();
        }
    }

    @GetMapping({"viewByCustomer/{customerId}"})
    public ResponseEntity<List<Item>> viewAllOrders(@PathVariable("customerId") Integer customerId,@RequestParam String Key) throws OrderException, CustomerException,AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(Key);
        if (sessionId!=null){
            //List<Item> itemList = orderDetailsService.viewAllOrdersByCustomer(customerId);
            //return new ResponseEntity(itemList,HttpStatus.OK);
            return new ResponseEntity<List<Item>>(orderDetailsService.viewAllOrdersByCustomer(customerId),HttpStatus.OK);
        }else{
            throw new OrderException();
        }
    }

}

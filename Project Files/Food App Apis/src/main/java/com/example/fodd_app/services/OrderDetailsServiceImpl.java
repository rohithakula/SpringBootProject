package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CustomerException;
import com.example.Foodorderapp.exceptions.OrderException;
import com.example.Foodorderapp.model.Customer;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.model.OrderDetails;
import com.example.Foodorderapp.repositories.CustomerDAO;
import com.example.Foodorderapp.repositories.OrderDetailsDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    OrderDetailsDAO orderDetailsDAO;
    CustomerDAO customerDAO;

    @Override
    public OrderDetails addOrder(OrderDetails order) throws OrderException {
        Optional<OrderDetails> optionalOrderDetails = this.orderDetailsDAO.findById(order.getOrderId());
        if (optionalOrderDetails.isPresent()){
            throw new OrderException("Already exists..");
        }else{
            return orderDetailsDAO.save(order);
        }
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order) throws OrderException {
        Optional<OrderDetails> optionalOrderDetails = this.orderDetailsDAO.findById(order.getOrderId());
        if (optionalOrderDetails.isPresent()){
            return(OrderDetails) this.orderDetailsDAO.save(order);
        }else{
            throw new OrderException("Order Doesn't exists..");
        }
    }

    @Override
    public OrderDetails removeOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> optionalOrderDetails = this.orderDetailsDAO.findById(orderId);
        if(optionalOrderDetails.isPresent()){
            OrderDetails orderDetails = optionalOrderDetails.get();
            this.orderDetailsDAO.delete(orderDetails);
            return orderDetails;
        }else{
            throw new OrderException("Order not found by Id: " + orderId);
        }
    }

    @Override
    public OrderDetails viewOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> optionalOrderDetails = this.orderDetailsDAO.findById(orderId);
        OrderDetails order = optionalOrderDetails.get();
        return order;
    }

    @Override
    public List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException {

        Optional<Customer> optionalCustomer = this.customerDAO.findById(customerId);
        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            List<Item> itemList = customer.getFoodCart().getItemList();
            if (itemList.size()>0){
                return itemList;
            }else {
                throw new OrderException("Order not found");
            }
        }else {
            throw new CustomerException("Order not found by Id: " + customerId);
        }
    }
}

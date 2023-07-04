package com.example.Foodorderapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodCart {
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer cartId;


    @OneToOne(cascade = {CascadeType.ALL})
    @JsonIgnore
    private Customer customer;

    @OneToMany(targetEntity = Item.class,cascade = {CascadeType.ALL})
    private List<Item> itemList;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}

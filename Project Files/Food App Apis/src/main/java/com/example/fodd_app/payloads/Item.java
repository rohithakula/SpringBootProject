package com.example.Foodorderapp.model;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer itemId;
    private String itemName;
    private String quantity;
    private Double cost;


    @OneToOne(cascade = {CascadeType.ALL})
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Item(Integer itemId, String itemName, String quantity, Double cost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", cost=" + cost +
                '}';
    }
}

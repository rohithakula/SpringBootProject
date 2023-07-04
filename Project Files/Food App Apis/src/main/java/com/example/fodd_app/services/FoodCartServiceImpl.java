package com.example.Foodorderapp.service;

import com.example.Foodorderapp.exceptions.CartException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.FoodCart;
import com.example.Foodorderapp.model.Item;
import com.example.Foodorderapp.repositories.FoodCartDAO;
import com.example.Foodorderapp.repositories.ItemDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodCartServiceImpl implements FoodCartService{


    FoodCartDAO foodCartDAO;
    ItemDAO itemDAO;

    @Override
    public FoodCart saveCart(FoodCart cart) throws CartException {
        Optional<FoodCart> optionalFoodCart = this.foodCartDAO.findById(cart.getCartId());
        if (optionalFoodCart.isPresent()){
            throw new CartException("FoodCart already exists ..");
        }else{
            return foodCartDAO.save(cart);
        }
    }

    @Override
    public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
        Optional<FoodCart> optionalFoodCart = this.foodCartDAO.findById(cartId);
        if (optionalFoodCart.isPresent()){
            Optional<Item> optionalItem = this.itemDAO.findById(cartId);
            if (optionalItem.isPresent()){
                FoodCart foodCart = optionalFoodCart.get();
                Item item = optionalItem.get();
                List<Item> itemList= new ArrayList<>();
                itemList.addAll(foodCart.getItemList());
                itemList.add(item);
                foodCart.setItemList(itemList);
            }else {
                throw new ItemException("No item found by Id: "+ itemId);

            }

        } else{
            throw new CartException("No FoodCart found by Id:" + cartId);
        }
        return null;
    }

    @Override
    public FoodCart clearCart(Integer cartId) throws CartException {
        Optional<FoodCart> optionalFoodCart = this.foodCartDAO.findById(cartId);
        if (optionalFoodCart.isPresent()){
            FoodCart foodCart = optionalFoodCart.get();
            foodCartDAO.delete(foodCart);
            return foodCart;
        }else{
            throw new CartException("no cart found..");
        }

    }

    @Override
    public FoodCart viewCart(Integer cartId) throws CartException {
        Optional<FoodCart> optionalFoodCart = this.foodCartDAO.findById(cartId);
        if (optionalFoodCart.isPresent()){
            return optionalFoodCart.get();
        }else{
            throw new CartException("no cart found by Id"+ cartId);
        }
    }
}

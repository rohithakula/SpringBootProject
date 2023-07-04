package com.example.Foodorderapp.controllers;


import com.example.Foodorderapp.authExceptions.AuthorizationExceptions;
import com.example.Foodorderapp.authServices.UserService;
import com.example.Foodorderapp.exceptions.CartException;
import com.example.Foodorderapp.exceptions.ItemException;
import com.example.Foodorderapp.model.FoodCart;
import com.example.Foodorderapp.service.FoodCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/cart"})
public class FoodCartServiceController {

    public FoodCartServiceController(){

    }
    FoodCartService foodCartService;

    UserService userService;

    @PostMapping({"/save"})
    public ResponseEntity<FoodCart> saveCart(@RequestBody FoodCart cart,@RequestBody String Key) throws CartException, AuthorizationExceptions {
        Integer sessionId = userService.getUserSessionId(Key);
        if(cart!=null && sessionId!=null){
            FoodCart saveCart = this.foodCartService.saveCart(cart);
            return new ResponseEntity(saveCart, HttpStatus.CREATED);
        }else{
            throw new CartException();
        }
    }

    @PutMapping({"/add/{itemId}/{cartId}"})
    public ResponseEntity<FoodCart> addCart(@PathVariable("itemId") Integer itemId , @PathVariable("cartId") Integer cartId ) throws CartException, ItemException{
        FoodCart addCart = this.foodCartService.addItem(itemId, cartId);
        return new ResponseEntity(addCart,HttpStatus.CREATED);
    }

    @DeleteMapping({"/remove/{cartId}"})
    public ResponseEntity<FoodCart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
        FoodCart removeCart = this.foodCartService.clearCart(cartId);
        return new ResponseEntity(removeCart,HttpStatus.OK);
    }

    @GetMapping({"view/{cartId}"})
    public ResponseEntity<FoodCart> viewCart(@PathVariable("cartId") Integer cartId ,@RequestParam String Key) throws CartException,AuthorizationExceptions{
        Integer sessionId = userService.getUserSessionId(Key);
        if(sessionId!=null){
            return new ResponseEntity<FoodCart>(foodCartService.viewCart(cartId),HttpStatus.OK);
        }else{
            throw new CartException();
        }
    }



}

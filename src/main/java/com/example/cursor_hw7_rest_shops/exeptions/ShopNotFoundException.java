package com.example.cursor_hw7_rest_shops.exeptions;

public class ShopNotFoundException extends RuntimeException{
    public ShopNotFoundException(String message) {
        super(message);
    }
}

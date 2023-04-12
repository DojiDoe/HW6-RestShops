package com.example.cursor_hw7_rest_shops.service;

import com.example.cursor_hw7_rest_shops.entity.Shop;

import java.util.List;

public interface ShopService {
    void save(Shop shop);
    void deleteById(Long id);
    List<Shop> getAll();
    Shop getById(Long id);
    Shop update(Long id, Shop newShop);
}

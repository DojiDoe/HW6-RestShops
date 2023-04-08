package com.example.cursor_hw7_rest_shops.service;

import com.example.cursor_hw7_rest_shops.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShopService {

    private HashMap<Long, Shop> db = new HashMap<>();

    public void save(Shop shop){
        db.put(shop.getId(), shop);
    }

    public  boolean deleteById(Long id){
        Object removedObject = db.remove(id);
        return removedObject != null;
    }

    public List<Shop> getAll(){
        return db.values().stream().toList();
    }

    public Shop getById(Long id){
        return db.get(id);
    }

    public Shop update(Long id, Shop shop){
       return db.put(id,shop);
    }

}

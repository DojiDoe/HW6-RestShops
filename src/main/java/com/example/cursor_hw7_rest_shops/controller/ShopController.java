package com.example.cursor_hw7_rest_shops.controller;

import com.example.cursor_hw7_rest_shops.entity.Shop;
import com.example.cursor_hw7_rest_shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/shops",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> create(@RequestBody Shop shop) {
        shopService.save(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/shops/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        boolean isDeleted = shopService.deleteById(id);
        if (isDeleted) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/shops")
    public ResponseEntity<List<Shop>> getAll() {
        List<Shop> list = shopService.getAll();
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/shops/{id}")
    public ResponseEntity<Shop> getById(@PathVariable Long id) {
        Shop shop = shopService.getById(id);
        if (shop != null) {
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/shops/{id}")
    public ResponseEntity<Shop> update(@PathVariable Long id,
                                       @RequestBody Shop shop) {
        Shop updatedShop = shopService.update(id, shop);
        if (updatedShop != null) {
            return new ResponseEntity<>(updatedShop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}

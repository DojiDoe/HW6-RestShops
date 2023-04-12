package com.example.cursor_hw7_rest_shops.web.rest;

import com.example.cursor_hw7_rest_shops.entity.Shop;
import com.example.cursor_hw7_rest_shops.exeptions.ShopNotFoundException;
import com.example.cursor_hw7_rest_shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> create(@RequestBody Shop shop) {
        try {
            shopService.save(shop);
            return new ResponseEntity<>(shop,HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        try {
            shopService.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (ShopNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAll() {
        List<Shop> list = shopService.getAll();
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Shop> getById(@PathVariable Long id) {
        try {
            Shop shop = shopService.getById(id);
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } catch (ShopNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Shop> update(@PathVariable Long id,
                                       @RequestBody Shop shop) {
        try {
            Shop updatedShop = shopService.update(id, shop);
            return new ResponseEntity<>(updatedShop, HttpStatus.OK);
        } catch (ShopNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

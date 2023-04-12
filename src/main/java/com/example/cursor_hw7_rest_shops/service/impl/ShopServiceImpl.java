package com.example.cursor_hw7_rest_shops.service.impl;

import com.example.cursor_hw7_rest_shops.entity.Shop;
import com.example.cursor_hw7_rest_shops.exeptions.ShopNotFoundException;
import com.example.cursor_hw7_rest_shops.repository.ShopRepository;
import com.example.cursor_hw7_rest_shops.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    public void save(Shop shop){
        shopRepository.save(shop);
    }

    public  void deleteById(Long id) throws ShopNotFoundException{
      if(shopRepository.existsById(id)){
          shopRepository.deleteById(id);
      }else{
          throw new ShopNotFoundException("Not found Shop  with id" + id);
      }
    }

    public List<Shop> getAll(){
        return (List<Shop>) shopRepository.findAll();
    }

    public Shop getById(Long id){
        return shopRepository.findById(id).orElseThrow(() -> new ShopNotFoundException("Not Found"));
    }

    public Shop update(Long id, Shop newShop){
        Optional<Shop> foundShop = shopRepository.findById(id);
        if(foundShop.isPresent()){
            newShop.setId(id);
            shopRepository.save(newShop);
            return newShop;
        }else {
            throw new ShopNotFoundException("No shop  to update by that id");
        }
    }

}

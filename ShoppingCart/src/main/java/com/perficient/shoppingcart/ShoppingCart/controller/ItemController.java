package com.perficient.shoppingcart.ShoppingCart.controller;

import com.perficient.shoppingcart.ShoppingCart.domain.Item;
import com.perficient.shoppingcart.ShoppingCart.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ShoppingCart/api/v1")
public class ItemController {

    private ItemService itemService;
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @PostMapping(value = "/adding")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){

        item = itemService.addItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
}

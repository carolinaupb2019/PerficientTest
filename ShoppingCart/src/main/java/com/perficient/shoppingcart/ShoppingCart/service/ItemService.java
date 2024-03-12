package com.perficient.shoppingcart.ShoppingCart.service;

import com.perficient.shoppingcart.ShoppingCart.domain.Item;
import com.perficient.shoppingcart.ShoppingCart.repository.IItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final IItemRepository repository;

    public ItemService(IItemRepository repository) {
        this.repository = repository;
    }

    public Item addItem(Item item){
        return  repository.save(item);

    }

    public void deleteItem(Item item){
        repository.deleteById(item.getId());
    }

    public String getStatusItem(Integer itemId){

        Item i = new Item();

        Optional<String> s = repository.findById(itemId)
                .map(item -> item.getStatus());
        return s.get();

    }

    public List<Item> findAllItems(){
        return repository.findAll();

    }

    public Optional<Item> findById(Integer idItem){
        return repository.findById(idItem);

    }


}

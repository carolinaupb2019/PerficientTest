package com.perficient.shoppingcart.ShoppingCart.repository;

import com.perficient.shoppingcart.ShoppingCart.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {
}

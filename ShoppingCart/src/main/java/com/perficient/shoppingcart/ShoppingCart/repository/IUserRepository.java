package com.perficient.shoppingcart.ShoppingCart.repository;

import com.perficient.shoppingcart.ShoppingCart.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

}

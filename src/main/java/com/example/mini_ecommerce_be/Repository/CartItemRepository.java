package com.example.mini_ecommerce_be.Repository;

import com.example.mini_ecommerce_be.Entity.Cart;
import com.example.mini_ecommerce_be.Entity.CartItem;
import com.example.mini_ecommerce_be.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
}

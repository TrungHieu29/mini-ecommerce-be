package com.example.mini_ecommerce_be.Service.Cart;

import com.example.mini_ecommerce_be.Entity.Cart;

public interface CartService {

    Cart getCartByUserId(Long userId);
    Cart addProductToCart(Long userId, Long productId, Integer quantity);
    Cart removeProductFromCart(Long userId, Long productId);
    Cart updateProductQuantity(Long userId, Long productId, Integer quantity);
    double calculateTotal(Cart cart);
}

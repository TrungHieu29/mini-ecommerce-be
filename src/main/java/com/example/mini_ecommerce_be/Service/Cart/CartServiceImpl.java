package com.example.mini_ecommerce_be.Service.Cart;

import com.example.mini_ecommerce_be.Entity.Cart;
import com.example.mini_ecommerce_be.Entity.CartItem;
import com.example.mini_ecommerce_be.Entity.Product;
import com.example.mini_ecommerce_be.Exception.InsufficientStockException;
import com.example.mini_ecommerce_be.Exception.ResourceNotFoundException;
import com.example.mini_ecommerce_be.Repository.CartRepository;
import com.example.mini_ecommerce_be.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user id: " + userId));
    }

    @Transactional
    @Override
    public Cart addProductToCart(Long userId, Long productId, Integer quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUserId(userId);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + productId));

        CartItem existingItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElse(null);

        int newQuantity = quantity;

        if (existingItem != null) {
            newQuantity = existingItem.getQuantity() + quantity;
        }

        if (newQuantity > product.getStock()) {
            throw new InsufficientStockException("Not enough stock for product id: " + productId);
        }

        if (existingItem != null) {
            existingItem.setQuantity(newQuantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cart.getCartItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    @Transactional
    @Override
    public Cart removeProductFromCart(Long userId, Long productId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user id: " + userId));

        boolean removed = cart.getCartItems()
                .removeIf(item -> item.getProduct().getProductId().equals(productId));

        if (!removed) {
            throw new ResourceNotFoundException("Product not found in cart");
        }

        return cartRepository.save(cart);
    }

    @Transactional
    @Override
    public Cart updateProductQuantity(Long userId, Long productId, Integer quantity) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user id: " + userId));

        CartItem cartItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found in cart"));

        if (quantity <= 0) {
            cart.getCartItems().remove(cartItem);
            return cartRepository.save(cart);
        }

        if (quantity > cartItem.getProduct().getStock()) {
            throw new InsufficientStockException("Not enough stock for product id: " + productId);
        }

        cartItem.setQuantity(quantity);

        return cartRepository.save(cart);
    }
}
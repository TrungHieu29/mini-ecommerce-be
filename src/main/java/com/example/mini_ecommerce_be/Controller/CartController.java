package com.example.mini_ecommerce_be.Controller;

import com.example.mini_ecommerce_be.Controller.DTO.AddCartRequest;
import com.example.mini_ecommerce_be.Controller.DTO.CartItemRequest;
import com.example.mini_ecommerce_be.Service.Cart.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItemsToCart(@RequestBody AddCartRequest request) {

        for (CartItemRequest item : request.getItems()) {
            cartService.addProductToCart(
                    request.getUserId(),
                    item.getProductId(),
                    item.getQuantity()
            );
        }

        return ResponseEntity.ok(
                cartService.getCartByUserId(request.getUserId())
        );
    }

    @PutMapping("/user/{userId}/products/{productId}")
    public ResponseEntity<?> updateItemQuantity(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @RequestParam Integer quantity
    ) {
        return ResponseEntity.ok(
                cartService.updateProductQuantity(userId, productId, quantity)
        );
    }

    @DeleteMapping("/user/{userId}/products/{productId}")
    public ResponseEntity<?> removeItemFromCart(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        return ResponseEntity.ok(
                cartService.removeProductFromCart(userId, productId)
        );
    }
}
package com.example.mini_ecommerce_be.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {

    private Long userId;

    private List<CartItemRequest> items;

}
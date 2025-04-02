package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.Cart;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/cart")
public class CartController {
    private final ICartService cartService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getCart(){
        Cart Cart = cartService.getCart();
        return ResponseEntity.ok(new ApiResponse("Cart retrieved successfully", Cart));
    }
}

package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.CartItem;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.cartItem.ICartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/cart-items")
public class CartItemController {
    private final ICartItemService cartItemService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCartItemInCart(@RequestParam String quantity,@RequestParam String productId) {
        CartItem cartItem = cartItemService.addCartItemInCart(quantity, productId);
        return ResponseEntity.ok(new ApiResponse("Product added in cart successfully", cartItem));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<ApiResponse> deleteCartItemInCart(@RequestParam String cartItemId) {
        CartItem cartItem = cartItemService.deleteCartItemInCart(cartItemId);
        return ResponseEntity.ok(new ApiResponse("Product deleted in cart successfully", cartItem));
    }
    
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateCartItemInCart(@RequestParam String quantity, @RequestParam String cartItemId) {
        CartItem cartItem = cartItemService.updateCartItemInCart(quantity, cartItemId);
        return ResponseEntity.ok(new ApiResponse("Product in cart updated successfully", cartItem));
    }
}

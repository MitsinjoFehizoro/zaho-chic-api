package edu.mitsinjo.zahochic.service.cartItem;

import edu.mitsinjo.zahochic.model.CartItem;

public interface ICartItemService {
    CartItem getCartItemById(String cartItemId);

    CartItem createCartItem(String quantity, String productId);

    CartItem addCartItemInCart(String quantity, String productId);

    CartItem deleteCartItemInCart(String cartItemId);

    CartItem updateCartItemInCart(String quantity, String cartItemId);
}

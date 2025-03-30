package edu.mitsinjo.zahochic.service.cart;

import edu.mitsinjo.zahochic.model.Cart;
import edu.mitsinjo.zahochic.model.User;

public interface ICartService {
    Cart getCartById(Long id);
    Cart createCart(Cart cart);
    Cart updateCart(Cart cart, Long cartId);
}

package edu.mitsinjo.zahochic.service.cart;

import edu.mitsinjo.zahochic.model.Cart;
import edu.mitsinjo.zahochic.model.User;
import edu.mitsinjo.zahochic.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final IUserService userService;

    @Override
    public Cart getCart(){
        User currentUser = userService.currentUser();
        return currentUser.getCart();
    }
}

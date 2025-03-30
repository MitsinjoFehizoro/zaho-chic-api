package edu.mitsinjo.zahochic.service.cart;

import edu.mitsinjo.zahochic.exception.ResourceNotFoundException;
import edu.mitsinjo.zahochic.model.Cart;
import edu.mitsinjo.zahochic.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart non trouvé."));
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart, Long cartId) {
        return Optional.ofNullable(getCartById(cartId))
                .map(oldCart -> {
                    oldCart.setTotalAmount(cart.getTotalAmount());
                    return cartRepository.save(oldCart);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Cart non trouvé."));
    }
}

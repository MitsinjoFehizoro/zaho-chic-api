package edu.mitsinjo.zahochic.service.cartItem;

import edu.mitsinjo.zahochic.exception.ResourceNotFoundException;
import edu.mitsinjo.zahochic.model.CartItem;
import edu.mitsinjo.zahochic.model.Product;
import edu.mitsinjo.zahochic.model.User;
import edu.mitsinjo.zahochic.repository.CartItemRepository;
import edu.mitsinjo.zahochic.service.product.IProductService;
import edu.mitsinjo.zahochic.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService {
    private final CartItemRepository cartItemRepository;
    private final IProductService productService;
    private final IUserService userService;

    @Override
    public CartItem getCartItemById(String cartItemId) {
        Long cartItemIdValid = Long.parseLong(cartItemId);

        return Optional.of(cartItemRepository.findById(cartItemIdValid))
                .orElseThrow().orElseThrow(() -> new ResourceNotFoundException("CartItem with id " + cartItemId + " not found"));
    }

    @Override
    public CartItem createCartItem(String quantity, String productId) {
        int quantityValid = Integer.parseInt(quantity);

        Product product = productService.getProductById(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantityValid);
        cartItem.setTotalPrice(product.getPrice().multiply(new BigDecimal(quantity)));
        return cartItem;
    }

    @Override
    public CartItem addCartItemInCart(String quantity, String productId) {
        CartItem cartItem = createCartItem(quantity, productId);
        User currentUser = userService.currentUser();
        currentUser.getCart().addInCartItem(cartItem);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem deleteCartItemInCart(String cartItemId) {
        Long cartItemIdValid = Long.parseLong(cartItemId);

        CartItem cartItem = cartItemRepository.findById(cartItemIdValid)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found."));
        User currentUser = userService.currentUser();
        CartItem cartItemToDelete = currentUser.getCart().getCartItems().stream()
                .filter(item -> item.equals(cartItem))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Attempt to delete product not yet in cart"));
        currentUser.getCart().removeInCartItem(cartItemToDelete);
        cartItemRepository.deleteById(cartItemToDelete.getId());
        return cartItemToDelete;
    }

    @Override
    public CartItem updateCartItemInCart(String quantity, String cartItemId) {

        Long cartItemIdValid = Long.parseLong(cartItemId);
        int quantityValid = Integer.parseInt(quantity);

        CartItem cartItem = cartItemRepository.findById(cartItemIdValid)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found."));
        User currentUser = userService.currentUser();
        CartItem cartItemToUpdate = currentUser.getCart().getCartItems().stream()
                .filter(item -> item.equals(cartItem))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Attempt to update product not yet in cart"));
        cartItemToUpdate.setQuantity(quantityValid);
        cartItemToUpdate.setTotalPrice(cartItem.getProduct().getPrice().multiply(new BigDecimal(quantity)));
        cartItemToUpdate.getCart().updateTotalAmount();
        return cartItemRepository.save(cartItemToUpdate);
    }
}

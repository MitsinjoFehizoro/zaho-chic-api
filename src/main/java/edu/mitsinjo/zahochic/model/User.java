package edu.mitsinjo.zahochic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20 , message = "Username must be beetwen 3 and 20 characters longs.")
    private String username;

    @NotNull
    @Size(min = 4, message = "Password must be at least 4 characters.")
    private String password;

    private String role;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public void createCart(){
        Cart cart = new Cart(BigDecimal.ZERO);
        cart.setUser(this);
        this.setCart(cart);
    }

}

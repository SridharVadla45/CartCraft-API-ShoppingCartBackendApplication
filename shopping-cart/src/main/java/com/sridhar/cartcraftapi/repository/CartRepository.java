package com.sridhar.cartcraftapi.repository;

import com.sridhar.cartcraftapi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}

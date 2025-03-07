package com.sridhar.cartcraftapi.repository;

import com.sridhar.cartcraftapi.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}

package com.sridhar.cartcraftapi.repository;

import com.sridhar.cartcraftapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

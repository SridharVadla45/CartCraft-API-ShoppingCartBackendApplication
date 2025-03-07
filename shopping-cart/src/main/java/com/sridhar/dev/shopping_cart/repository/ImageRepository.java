package com.sridhar.dev.shopping_cart.repository;

import com.sridhar.dev.shopping_cart.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}

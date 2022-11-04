package com.ecommerce.ecommerceapi.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);

    List<UserEntity> findById(long id);
}

package com.example.smart_house.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smart_house.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    Optional <User> findByUsername (String username);
}

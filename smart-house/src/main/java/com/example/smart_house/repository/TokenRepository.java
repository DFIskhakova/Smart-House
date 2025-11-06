package com.example.smart_house.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smart_house.model.Token;

@Repository
public interface TokenRepository extends JpaRepository <Token, Long> {
    Optional <Token> findByValue(String value);
}

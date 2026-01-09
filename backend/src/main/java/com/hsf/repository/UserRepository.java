package com.hsf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsf.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

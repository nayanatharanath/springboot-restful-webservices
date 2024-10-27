package com.spring_boot.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.rest_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

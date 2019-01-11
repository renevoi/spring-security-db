package com.renevoi.springsecurity.springsecuritydb.repository;

import com.renevoi.springsecurity.springsecuritydb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByName(String username);
}

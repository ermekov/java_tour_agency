package com.postgresql.java_tour_agenstvo.Repository;

import com.postgresql.java_tour_agenstvo.Tour.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

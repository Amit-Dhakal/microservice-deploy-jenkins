package org.example.security.repository;

import jakarta.persistence.Id;
import org.example.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Id>{
Optional<User> findByUsernameOrEmail(String username,String email);

}




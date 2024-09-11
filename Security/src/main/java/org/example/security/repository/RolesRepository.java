package org.example.security.repository;

import jakarta.persistence.Id;
import org.example.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Id> {


}

package com.kaiser.login.repository;

import com.kaiser.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("releRepository")
public interface RoleRepository extends JpaRepository <Role, Integer> {
    Role findByRole(String role);
}

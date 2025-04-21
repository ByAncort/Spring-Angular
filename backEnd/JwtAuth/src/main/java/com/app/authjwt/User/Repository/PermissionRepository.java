package com.app.authjwt.User.Repository;

import com.app.authjwt.User.Model.Permission;
import com.app.authjwt.User.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    boolean existsByName(String roleName);

    Optional<Permission> findByName(String name);
}

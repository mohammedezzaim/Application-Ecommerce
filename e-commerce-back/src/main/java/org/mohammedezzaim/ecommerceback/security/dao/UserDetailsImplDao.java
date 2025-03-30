package org.mohammedezzaim.ecommerceback.security.dao;

import org.mohammedezzaim.ecommerceback.security.bean.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ezzaim Mohammed
 **/
public interface UserDetailsImplDao extends JpaRepository<UserDetailsImpl, Long> {
    Optional<UserDetailsImpl> findByEmail(String email);
    boolean existsUserByEmail(String email);
    boolean existsByEmail(String email);
}

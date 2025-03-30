package org.mohammedezzaim.ecommerceback.security.dao;

import org.mohammedezzaim.ecommerceback.security.bean.GrantedAuthorityImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ezzaim Mohammed
 **/

@Repository
public interface GrantedAuthorityImplDao extends JpaRepository<GrantedAuthorityImpl, Integer> {
    Optional<GrantedAuthorityImpl> findByRole(String role);
}

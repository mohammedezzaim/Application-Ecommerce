package org.mohammedezzaim.ecommerceback.security.dao;

import org.mohammedezzaim.ecommerceback.security.bean.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ezzaim Mohammed
 **/
public interface VerificationCodeDao extends JpaRepository<VerificationCode,Long> {
    Optional<VerificationCode> findByCode(String token);
}

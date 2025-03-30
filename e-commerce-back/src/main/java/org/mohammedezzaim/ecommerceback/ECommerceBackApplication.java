package org.mohammedezzaim.ecommerceback;

import org.mohammedezzaim.ecommerceback.security.bean.GrantedAuthorityImpl;
import org.mohammedezzaim.ecommerceback.security.dao.GrantedAuthorityImplDao;
import org.mohammedezzaim.ecommerceback.security.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceBackApplication {


    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(GrantedAuthorityImplDao grantedAuthorityImplDao) {
        return args -> {
            if (grantedAuthorityImplDao.findByRole(Role.USER.name()).isEmpty()){
                GrantedAuthorityImpl grantedAuthorityImpl = GrantedAuthorityImpl.builder().role(Role.USER.name()).build();
                grantedAuthorityImplDao.save(grantedAuthorityImpl);
            }
            if (grantedAuthorityImplDao.findByRole(Role.ADMIN.name()).isEmpty()){
                grantedAuthorityImplDao.save(GrantedAuthorityImpl.builder().role(Role.ADMIN.name()).build());
            }
        };
    }

}

package org.mohammedezzaim.ecommerceback.dao.acteur;


import org.mohammedezzaim.ecommerceback.bean.acteur.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorDao extends JpaRepository<Administrator,Integer> {

}

package org.mohammedezzaim.ecommerceback.dao.acteur;

import org.mohammedezzaim.ecommerceback.bean.acteur.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
}

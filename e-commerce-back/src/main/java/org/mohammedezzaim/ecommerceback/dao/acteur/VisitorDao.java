package org.mohammedezzaim.ecommerceback.dao.acteur;

import org.mohammedezzaim.ecommerceback.bean.acteur.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorDao extends JpaRepository<Visitor,Integer> {
}

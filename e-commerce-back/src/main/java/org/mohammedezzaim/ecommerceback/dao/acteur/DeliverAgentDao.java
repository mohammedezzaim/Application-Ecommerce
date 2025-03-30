package org.mohammedezzaim.ecommerceback.dao.acteur;

import org.mohammedezzaim.ecommerceback.bean.acteur.DeliverAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverAgentDao extends JpaRepository<DeliverAgent,Integer> {
}

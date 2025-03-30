package org.mohammedezzaim.ecommerceback.dao.acteur;

import org.mohammedezzaim.ecommerceback.bean.acteur.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDao extends JpaRepository<Vendor,Integer> {
}

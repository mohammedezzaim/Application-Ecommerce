package org.mohammedezzaim.ecommerceback.dao.address;


import org.mohammedezzaim.ecommerceback.bean.adress.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}

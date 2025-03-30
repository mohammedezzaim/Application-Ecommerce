package org.mohammedezzaim.ecommerceback.dao.order;

import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
}

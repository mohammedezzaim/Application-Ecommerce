package org.mohammedezzaim.ecommerceback.dao.order;

import org.mohammedezzaim.ecommerceback.bean.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductDao extends JpaRepository<OrderProduct,Integer> {
}

package org.mohammedezzaim.ecommerceback.dao.product;

import org.mohammedezzaim.ecommerceback.bean.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
}

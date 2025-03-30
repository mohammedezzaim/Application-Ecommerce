package org.mohammedezzaim.ecommerceback.dao.product;

import org.mohammedezzaim.ecommerceback.bean.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {
}

package org.mohammedezzaim.ecommerceback.dao.product;

import org.mohammedezzaim.ecommerceback.bean.product.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
}

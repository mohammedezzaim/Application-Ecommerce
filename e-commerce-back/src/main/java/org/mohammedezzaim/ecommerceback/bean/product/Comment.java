package org.mohammedezzaim.ecommerceback.bean.product;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.mohammedezzaim.ecommerceback.bean.acteur.Customer;

import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class Comment {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Integer id;

     @Column(name = "commentaire" , columnDefinition = "TEXT")
     private String commentCustomer;

     @CreationTimestamp
     @Column(name = "date")
     private LocalDateTime dateComment;

     @Column(name = "start")
     private int star;

     @ManyToOne
     @JoinColumn(name = "customer_id" , nullable = false)
     private Customer customer;

     @ManyToOne
     @JoinColumn(name = "product_id" , nullable = false)
     private Product product;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getCommentCustomer() {
          return commentCustomer;
     }

     public void setCommentCustomer(String commentCustomer) {
          this.commentCustomer = commentCustomer;
     }

     public LocalDateTime getDateComment() {
          return dateComment;
     }

     public void setDateComment(LocalDateTime dateComment) {
          this.dateComment = dateComment;
     }

     public int getStar() {
          return star;
     }

     public void setStar(int star) {
          this.star = star;
     }

     public Customer getCustomer() {
          return customer;
     }

     public void setCustomer(Customer customer) {
          this.customer = customer;
     }

     public Product getProduct() {
          return product;
     }

     public void setProduct(Product product) {
          this.product = product;
     }
}

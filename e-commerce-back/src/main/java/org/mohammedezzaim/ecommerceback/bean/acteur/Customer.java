package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.mohammedezzaim.ecommerceback.bean.product.Comment;

import java.util.List;


@Entity
@Table(name = "customer")

public class Customer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
//    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

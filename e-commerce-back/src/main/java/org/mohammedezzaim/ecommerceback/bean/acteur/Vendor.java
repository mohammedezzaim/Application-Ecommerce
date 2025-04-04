package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.mohammedezzaim.ecommerceback.bean.product.Product;
import org.mohammedezzaim.ecommerceback.security.bean.UserDetailsImpl;

import java.util.List;

@Entity
@Table(name = "Vendor")
public class Vendor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "storename")
    private String storeName;

    @OneToMany(mappedBy = "vendor")
    List<Product> products ;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToOne
    private Administrator administrator;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetailsImpl userDetails;

    public Vendor(Integer id, String storeName, List<Product> products, List<Order> orders, Administrator administrator) {
        this.id = id;
        this.storeName = storeName;
        this.products = products;
        this.orders = orders;
        this.administrator = administrator;
    }

    public Vendor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public UserDetailsImpl getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsImpl userDetails) {
        this.userDetails = userDetails;
    }
}

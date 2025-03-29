package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.mohammedezzaim.ecommerceback.bean.product.Product;

import java.util.List;

@Entity
@Table(name = "Vendor")
public class Vendor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "storename")
    private String storeName;

    @OneToMany(mappedBy = "vendor")
    List<Product> products ;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToOne
    private Administrator administrator;

    public Vendor(Long id, String storeName, List<Product> products, List<Order> orders, Administrator administrator) {
        this.id = id;
        this.storeName = storeName;
        this.products = products;
        this.orders = orders;
        this.administrator = administrator;
    }

    public Vendor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}

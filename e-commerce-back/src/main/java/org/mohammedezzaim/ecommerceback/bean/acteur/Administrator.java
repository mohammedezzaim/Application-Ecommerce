package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.mohammedezzaim.ecommerceback.bean.payment.Payment;
import org.mohammedezzaim.ecommerceback.bean.product.Category;
import org.mohammedezzaim.ecommerceback.bean.product.Product;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "administrator")
public class Administrator extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "isadmin")
    private boolean isAdmin;

    @Column(name = "issuperadmin")
    private boolean isSuperAdmin;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "administrator")
    private List<Product> products;

    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY  )
    private Set<Category> categories;

    @OneToMany(mappedBy = "administrator")
    private Set<DeliverAgent> deliverAgents;

    @OneToMany(mappedBy = "administrator")
    private Set<Vendor> vendors;

    @OneToMany(mappedBy = "administrator")
    private Set<Order> orders;

    @OneToMany(mappedBy = "administrator")
    private Set<Payment> payments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<DeliverAgent> getDeliverAgents() {
        return deliverAgents;
    }

    public void setDeliverAgents(Set<DeliverAgent> deliverAgents) {
        this.deliverAgents = deliverAgents;
    }

    public Set<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Payment> getPayments() {
        return payments;
    }


    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}

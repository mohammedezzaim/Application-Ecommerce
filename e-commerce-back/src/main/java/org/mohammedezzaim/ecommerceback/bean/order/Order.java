package org.mohammedezzaim.ecommerceback.bean.order;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.acteur.Administrator;
import org.mohammedezzaim.ecommerceback.bean.acteur.Customer;
import org.mohammedezzaim.ecommerceback.bean.acteur.DeliverAgent;
import org.mohammedezzaim.ecommerceback.bean.acteur.Vendor;
import org.mohammedezzaim.ecommerceback.enumeration.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ref")
    private String ref;


    @Column(name = "price" ,precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "url")
    private String imageUrl;

    @Column(name = "description" ,columnDefinition = "TEXT")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> orderProduct;

    @ManyToOne
    @JoinColumn(name = "delivery")
    private DeliverAgent deliverAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator")
    private Administrator administrator;

    public Order(Long id, String ref, BigDecimal price, String imageUrl, String description, OrderStatus status, Customer customer, Vendor vendor, List<OrderProduct> orderProduct, DeliverAgent deliverAgent, Administrator administrator) {
        this.id = id;
        this.ref = ref;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.status = status;
        this.customer = customer;
        this.vendor = vendor;
        this.orderProduct = orderProduct;
        this.deliverAgent = deliverAgent;
        this.administrator = administrator;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public DeliverAgent getDeliverAgent() {
        return deliverAgent;
    }

    public void setDeliverAgent(DeliverAgent deliverAgent) {
        this.deliverAgent = deliverAgent;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}

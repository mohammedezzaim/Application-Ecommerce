package org.mohammedezzaim.ecommerceback.bean.order;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.product.Product;

import java.math.BigDecimal;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    @Column(name = "ref" ,unique = true, nullable = false)
    private String ref;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_product",precision = 10, scale = 2)
    private BigDecimal unitOnePrice;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitOnePrice() {
        return unitOnePrice;
    }

    public void setUnitOnePrice(BigDecimal unitOnePrice) {
        this.unitOnePrice = unitOnePrice;
    }
}

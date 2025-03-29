package org.mohammedezzaim.ecommerceback.bean.acteur;


import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sessionid")
    private String sessionId;

    @Column(name = "visitedate")
    private LocalDateTime visitDate;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id")
    private List<Product> productList = new ArrayList<>();

    public Visitor() {

    }

    public Visitor(Long id, String sessionId, LocalDateTime visitDate, List<Product> productList) {
        this.id = id;
        this.sessionId = sessionId;
        this.visitDate = visitDate;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

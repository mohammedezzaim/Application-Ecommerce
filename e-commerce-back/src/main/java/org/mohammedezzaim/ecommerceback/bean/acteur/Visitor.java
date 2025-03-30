package org.mohammedezzaim.ecommerceback.bean.acteur;


import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.product.Product;
import org.mohammedezzaim.ecommerceback.security.bean.UserDetailsImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sessionid")
    private String sessionId;

    @Column(name = "visitedate")
    private LocalDateTime visitDate;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_id")
    private List<Product> productList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetailsImpl userDetails;

    public Visitor() {

    }

    public Visitor(Integer id, String sessionId, LocalDateTime visitDate, List<Product> productList) {
        this.id = id;
        this.sessionId = sessionId;
        this.visitDate = visitDate;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public UserDetailsImpl getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsImpl userDetails) {
        this.userDetails = userDetails;
    }
}

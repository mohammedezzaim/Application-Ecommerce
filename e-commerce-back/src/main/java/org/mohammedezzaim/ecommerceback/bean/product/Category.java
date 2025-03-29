package org.mohammedezzaim.ecommerceback.bean.product;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.acteur.Administrator;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ref" ,unique = true, nullable = false)
    private String ref;

    @Column(name = "name")
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "percentage")
    private BigDecimal percentage;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

    public Category() {

    }

    public Category(Long id, String ref, String name, String description, BigDecimal percentage, Set<Product> products, Administrator administrator) {
        this.id = id;
        this.ref = ref;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.products = products;
        this.administrator = administrator;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}

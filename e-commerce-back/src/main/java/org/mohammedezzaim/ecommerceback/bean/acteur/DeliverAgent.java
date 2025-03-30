package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.*;
import org.mohammedezzaim.ecommerceback.bean.order.Order;
import org.mohammedezzaim.ecommerceback.enumeration.DeliveryAgentStatus;

import java.util.List;


@Entity
@Table(name = "deliveragent")
public class DeliverAgent extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "zone")
    private String zone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DeliveryAgentStatus status;

    @OneToMany(mappedBy = "deliverAgent", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Order> orders;

    @ManyToOne
    private Administrator administrator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public DeliveryAgentStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryAgentStatus status) {
        this.status = status;
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

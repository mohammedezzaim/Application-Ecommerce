package org.mohammedezzaim.ecommerceback.bean.adress;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // Changed to Long

    @Column(name = "street")
    private String street;

    @Column(name = "house_number") // Adjusted column name
    private String houseNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode") // Consider changing to String for potential leading zeros
    private String zipCode; // Changed to String

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "person_id", nullable = false)
//    private Person person;

    // No-argument constructor
    public Address() {
    }

    // Getters and Setters...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

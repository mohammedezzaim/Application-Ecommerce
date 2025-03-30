package org.mohammedezzaim.ecommerceback.bean.acteur;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Person {

    @Column(name = "ref", unique = true, nullable = false)
    private String ref;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone")
    private String number;

    @Column(name = "birthday")
    private LocalDateTime dateOfBirth;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

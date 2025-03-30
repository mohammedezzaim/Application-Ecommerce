package org.mohammedezzaim.ecommerceback.security.bean;

import jakarta.persistence.*;
import lombok.*;
import org.mohammedezzaim.ecommerceback.bean.acteur.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ezzaim Mohammed
 **/
@Getter
@Setter
@Builder
@Entity
@Table(name = "userApp")
@EntityListeners(AuditingEntityListener.class)
public class UserDetailsImpl implements UserDetails, Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
    }

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<GrantedAuthorityImpl> roles;

    @OneToOne(mappedBy = "userDetails", fetch = FetchType.LAZY)
    private Administrator administrator;

    @OneToOne(mappedBy = "userDetails", fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "userDetails", fetch = FetchType.LAZY)
    private DeliverAgent deliverAgent;

    @OneToOne(mappedBy = "userDetails", fetch = FetchType.LAZY)
    private Vendor vendor;

    @OneToOne(mappedBy = "userDetails", fetch = FetchType.LAZY)
    private Visitor visitor;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r->new GrantedAuthorityImpl(r.getRole()))
                .collect(Collectors.toList());
    }

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(Integer id, String firstname, String lastname, LocalDate dateOfBirth, String email, String password, boolean accountLocked, boolean enabled, LocalDateTime createdDate, LocalDateTime lastModifiedDate, List<GrantedAuthorityImpl> roles, Administrator administrator, Customer customer, DeliverAgent deliverAgent, Vendor vendor, Visitor visitor) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.accountLocked = accountLocked;
        this.enabled = enabled;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.roles = roles;
        this.administrator = administrator;
        this.customer = customer;
        this.deliverAgent = deliverAgent;
        this.vendor = vendor;
        this.visitor = visitor;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return email;
    }

    public String fullName() {
        return firstname + " " + lastname;
    }

}

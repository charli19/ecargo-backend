package com.iceond.ecargo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment_method")
@Getter
@Setter
public class PaymentMethodEntity extends GenericEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_payment_method",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_method_id"))
    private Set<UserEntity> users;
}

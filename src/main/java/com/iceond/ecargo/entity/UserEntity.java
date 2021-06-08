package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.FavourEntity.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends GenericEntity {

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String name;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String surname;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String phoneNumber;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String email;

  @Column(nullable = false)
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd")
  private Date birthdayDate;

  @Column
  private String biography;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_permission",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<PermissionEntity> permissions;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<FavourEntity> favours;

  @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<FavourEntity> workerFavours;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "user_payment_method",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "payment_method_id"))
  private Set<PaymentMethodEntity> paymentMethod;

}

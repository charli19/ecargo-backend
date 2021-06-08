package com.iceond.ecargo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity extends GenericEntity {

  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  private Integer number;

  @Column
  private String door;

  @Column
  private String floor;

  @Column(nullable = false)
  private Integer zip_code;

  @Column(nullable = false)
  private String city;

 @Column(nullable = false)
  private String province;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

}

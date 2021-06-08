package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.FavourEntity.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity extends GenericEntity {

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<FavourEntity> favour;

  @JsonView(value = Views.Get.class)
  @Column private String name;
}

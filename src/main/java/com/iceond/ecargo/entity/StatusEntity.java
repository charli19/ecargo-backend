package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.FavourEntity.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "status")
@Getter
@Setter
public class StatusEntity extends GenericEntity {

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FavourEntity> favour;

    @Column
    @JsonView(value = Views.Get.class)
    private String name;

}

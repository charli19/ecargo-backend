package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permission")
@Getter
@Setter
public class PermissionEntity extends GenericEntity {

    @Column
    private String name;

    @ManyToMany()
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<UserEntity> users;
}

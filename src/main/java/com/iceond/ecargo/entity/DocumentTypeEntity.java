package com.iceond.ecargo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "document_type")
@Getter
@Setter
public class DocumentTypeEntity extends GenericEntity {

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

}

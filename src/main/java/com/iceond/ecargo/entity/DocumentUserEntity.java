package com.iceond.ecargo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "document_user")
@Getter
@Setter
public class DocumentUserEntity extends GenericEntity {


  @Column(nullable = false)
  private Byte[] image;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "document_type_id", nullable = false)
  private DocumentTypeEntity documentType;

}

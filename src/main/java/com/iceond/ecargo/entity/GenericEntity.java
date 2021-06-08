package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
public class GenericEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false, insertable = false)
  private Long id;

  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @JsonIgnore
  private Timestamp createdDate;

  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @JsonIgnore
  private Timestamp updatedDate;
}

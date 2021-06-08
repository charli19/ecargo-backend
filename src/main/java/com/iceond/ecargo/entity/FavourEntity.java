package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "favour")
@Getter
@Setter
public class FavourEntity extends GenericEntity {

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @JsonView(value = Views.Get.class)
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "worker_id")
  @JsonView(value = Views.Get.class)
  private UserEntity worker;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  @JsonView(value = Views.Get.class)
  private CategoryEntity category;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  @JsonView(value = Views.Get.class)
  private StatusEntity status;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String description;

  @Column(nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @JsonView(value = Views.Get.class)
  private Timestamp payedDate;

  @Column(nullable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @JsonView(value = Views.Get.class)
  private Timestamp limitDate;

  @Column(nullable = false)
  @JsonView(value = Views.Get.class)
  private String ubication;

  public static class Views {
    // show only get data
    public interface Get {}
  }
}

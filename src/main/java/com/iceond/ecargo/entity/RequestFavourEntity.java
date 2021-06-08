package com.iceond.ecargo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "request_favour")
@Getter
@Setter
public class RequestFavourEntity extends GenericEntity {


    @Column(nullable = false)
    @JsonView(value = Views.Get.class)
    private Double price;

    @Column
    @JsonView(value = Views.Get.class)
    private String observation;

    @ManyToOne
    @JoinColumn(name = "favour_id", nullable = false)
    @JsonView(value = Views.Get.class)
    private FavourEntity favour;

    @ManyToOne
    @JsonView(value = Views.Get.class)
    @JoinColumn(name = "worker_id", nullable = false)
    private UserEntity worker;

    public static class Views {
        // show only get data
        public interface Get {}
    }

}

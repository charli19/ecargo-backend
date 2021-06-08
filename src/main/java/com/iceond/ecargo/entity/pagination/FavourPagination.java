package com.iceond.ecargo.entity.pagination;

import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.FavourEntity.Views;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FavourPagination extends GenericPagination {

    @JsonView(value = Views.Get.class)
    private List<FavourEntity> favours;
}

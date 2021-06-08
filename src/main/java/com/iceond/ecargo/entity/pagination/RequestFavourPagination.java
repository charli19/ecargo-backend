package com.iceond.ecargo.entity.pagination;

import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.RequestFavourEntity.Views;
import com.iceond.ecargo.entity.RequestFavourEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFavourPagination extends GenericPagination {

    @JsonView(value = Views.Get.class)
    private List<RequestFavourEntity> requestFavours;
}

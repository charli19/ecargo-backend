package com.iceond.ecargo.entity.pagination;

import com.fasterxml.jackson.annotation.JsonView;
import com.iceond.ecargo.entity.FavourEntity.Views;
import com.iceond.ecargo.entity.RequestFavourEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenericPagination {

    @JsonView(value = {Views.Get.class, RequestFavourEntity.Views.Get.class})
    private long total;

}

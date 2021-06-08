package com.iceond.ecargo.entity.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavourFilter extends PaginationFilter {

    private Long userId;
    private Long categoryId;

}

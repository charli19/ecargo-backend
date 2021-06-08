package com.iceond.ecargo.entity.filter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaginationFilter implements Serializable {

    private int page;

    private int size;
}

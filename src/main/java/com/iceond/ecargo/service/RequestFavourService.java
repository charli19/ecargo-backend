package com.iceond.ecargo.service;

import com.iceond.ecargo.entity.RequestFavourEntity;
import com.iceond.ecargo.entity.filter.RequestFavourFilter;
import com.iceond.ecargo.entity.pagination.RequestFavourPagination;
import java.util.List;

public interface RequestFavourService {

  void createRequestFavour(RequestFavourEntity favourEntity);

  RequestFavourPagination getRequestFavourList(RequestFavourFilter requestFavourFilter);

  void deleteRequestFavour(long requestFavourId);
}

package com.iceond.ecargo.service;

import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.filter.FavourFilter;
import com.iceond.ecargo.entity.pagination.FavourPagination;

public interface FavourService {

  FavourPagination getFavourList(FavourFilter favourFilter);

  FavourEntity getFavourById(long favourId);

  void createFavour(FavourEntity favourEntity);
}

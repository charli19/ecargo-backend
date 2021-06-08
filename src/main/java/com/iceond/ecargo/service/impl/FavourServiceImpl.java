package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.common.StatusConstant;
import com.iceond.ecargo.repository.FavourRepository;
import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.filter.FavourFilter;
import com.iceond.ecargo.entity.pagination.FavourPagination;
import com.iceond.ecargo.service.FavourService;
import com.iceond.ecargo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.lucene.util.SloppyMath;

@Service
public class FavourServiceImpl implements FavourService {

  private final FavourRepository favourRepository;
  private final StatusService statusService;

  @Autowired
  public FavourServiceImpl(FavourRepository favourRepository, StatusService statusService) {
    this.favourRepository = favourRepository;
    this.statusService = statusService;
  }

  @Override
  @Transactional(readOnly = true)
  public FavourPagination getFavourList(FavourFilter favourFilter) {

    FavourPagination favourPagination = new FavourPagination();

    Page<FavourEntity> favourEntityPage = this.favourRepository.findAllByFilter(favourFilter);

    favourPagination.setFavours(favourEntityPage.getContent());
    favourPagination.setTotal(favourEntityPage.getTotalElements());

    return favourPagination;
  }

  @Override
  @Transactional(readOnly = true)
  public FavourEntity getFavourById(long favourId) {

    return this.favourRepository.findById(favourId);
  }

  @Override
  public void createFavour(FavourEntity favourEntity) {

    favourEntity.setStatus(this.statusService.findByName(StatusConstant.PUBLISHED));

    this.favourRepository.save(favourEntity);
  }
}

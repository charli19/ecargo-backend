package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.RequestFavourEntity;
import com.iceond.ecargo.entity.filter.FavourFilter;
import com.iceond.ecargo.entity.filter.RequestFavourFilter;
import com.iceond.ecargo.entity.pagination.FavourPagination;
import com.iceond.ecargo.entity.pagination.RequestFavourPagination;
import com.iceond.ecargo.repository.RequestFavourRepository;
import com.iceond.ecargo.service.RequestFavourService;
import com.iceond.ecargo.service.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestFavourServiceImpl implements RequestFavourService {

  private final RequestFavourRepository requestFavourRepository;
  private final StatusService statusService;

  @Autowired
  public RequestFavourServiceImpl(RequestFavourRepository requestFavourRepository, StatusService statusService) {
    this.requestFavourRepository = requestFavourRepository;
    this.statusService = statusService;
  }

  @Override
  public void createRequestFavour(RequestFavourEntity requestFavourEntity) {

    this.requestFavourRepository.save(requestFavourEntity);
  }

  @Override
  @Transactional(readOnly = true)
  public RequestFavourPagination getRequestFavourList(RequestFavourFilter requestFavourFilter) {

    RequestFavourPagination requestFavourPagination = new RequestFavourPagination();

    Page<RequestFavourEntity> requestFavourEntityPage = this.requestFavourRepository.findAllByFilter(requestFavourFilter);

    requestFavourPagination.setRequestFavours(requestFavourEntityPage.getContent());
    requestFavourPagination.setTotal(requestFavourEntityPage.getTotalElements());

    return requestFavourPagination;
  }


  @Override
  public void deleteRequestFavour(long requestFavourId) {
    this.requestFavourRepository.deleteById(requestFavourId);

  }

}

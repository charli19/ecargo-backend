package com.iceond.ecargo.repository;

import com.iceond.ecargo.entity.QRequestFavourEntity;
import com.iceond.ecargo.entity.RequestFavourEntity;
import com.iceond.ecargo.entity.filter.RequestFavourFilter;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface RequestFavourRepository extends GenericRepository<RequestFavourEntity> {


  /**
   * Find by favour filter.
   *
   * @param requestFavourFilter filter
   * @return page of favour.
   */
  default Page<RequestFavourEntity> findAllByFilter(RequestFavourFilter requestFavourFilter) {

    Pageable pageable = PageRequest.of(requestFavourFilter.getPage(), requestFavourFilter.getSize());

    return findAll(getBuilderByFilter(requestFavourFilter), pageable);
  }



  default BooleanBuilder getBuilderByFilter(RequestFavourFilter requestFavourFilter) {

    BooleanBuilder booleanBuilder = new BooleanBuilder();
    QRequestFavourEntity qRequestFavourEntity = QRequestFavourEntity.requestFavourEntity;

    if (requestFavourFilter.getFavourId() != null) {
      booleanBuilder.and(qRequestFavourEntity.favour.id.eq(requestFavourFilter.getFavourId()));
    }

    return booleanBuilder;
  }


}

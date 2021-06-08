package com.iceond.ecargo.repository;

import com.iceond.ecargo.common.StatusConstant;
import com.iceond.ecargo.entity.FavourEntity;
import com.iceond.ecargo.entity.QFavourEntity;
import com.iceond.ecargo.entity.filter.FavourFilter;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public interface FavourRepository extends GenericRepository<FavourEntity> {




  /**
   * Find by favour filter.
   *
   * @param favourFilter filter
   * @return page of favour.
   */
  default Page<FavourEntity> findAllByFilter(FavourFilter favourFilter) {

    Sort sort = Sort.by(Direction.DESC, "createdDate");
    Pageable pageable = PageRequest.of(favourFilter.getPage(), favourFilter.getSize(), sort);

    return findAll(getBuilderByFilter(favourFilter), pageable);
  }

  default BooleanBuilder getBuilderByFilter(FavourFilter favourFilter) {

    BooleanBuilder booleanBuilder = new BooleanBuilder();
    QFavourEntity qFavourEntity = QFavourEntity.favourEntity;

    booleanBuilder.and(qFavourEntity.status.name.eq(StatusConstant.PUBLISHED));

    if (favourFilter.getUserId() != null) {
      booleanBuilder.and(qFavourEntity.user.id.eq(favourFilter.getUserId()));
    }
    if (favourFilter.getCategoryId() != null) {
      booleanBuilder.and(qFavourEntity.category.id.eq(favourFilter.getCategoryId()));
    }

    return booleanBuilder;
  }

  FavourEntity findById(long favourId);
}

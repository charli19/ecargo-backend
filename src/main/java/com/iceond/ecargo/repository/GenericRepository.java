package com.iceond.ecargo.repository;

import com.iceond.ecargo.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GenericRepository<E extends GenericEntity>
    extends JpaRepository<E, Long>, QuerydslPredicateExecutor<E> {}

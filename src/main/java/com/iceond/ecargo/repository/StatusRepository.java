package com.iceond.ecargo.repository;

import com.iceond.ecargo.entity.StatusEntity;

public interface StatusRepository extends GenericRepository<StatusEntity> {

    StatusEntity findByName(String name);
}

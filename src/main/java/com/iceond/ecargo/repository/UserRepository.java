package com.iceond.ecargo.repository;

import com.iceond.ecargo.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<UserEntity> {

  UserEntity findByUsername(String username);

  List<UserEntity> findAll();

}

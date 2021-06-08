package com.iceond.ecargo.service;

import com.iceond.ecargo.entity.UserEntity;
import java.util.List;

public interface UserService {

  void createUser(UserEntity userEntity);

  UserEntity getUser(String username);

  List<UserEntity> getUsers();

}

package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.PermissionEntity;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.repository.UserRepository;
import com.iceond.ecargo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(
      UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public void createUser(UserEntity user) {

    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setPermissions(initDefaultPermission());

    userRepository.save(user);
  }

  private Set<PermissionEntity> initDefaultPermission() {

    Set<PermissionEntity> permissionEntities = new HashSet<>();

    PermissionEntity permissionEntity = new PermissionEntity();
    permissionEntity.setId(1L);

    permissionEntities.add(permissionEntity);

    return permissionEntities;
  }

  @Override
  public UserEntity getUser(String username) {

    return this.userRepository.findByUsername(username);
  }

  @Override
  public List<UserEntity> getUsers() {

    return this.userRepository.findAll();
  }
}

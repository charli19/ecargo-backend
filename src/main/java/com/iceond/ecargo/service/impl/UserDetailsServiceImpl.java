package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.PermissionEntity;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity applicationUser = userRepository.findByUsername(username);
    if (applicationUser == null) {
      throw new UsernameNotFoundException(username);
    }

    List<GrantedAuthority> authorities = new ArrayList<>();

    authorities.addAll(getAuthorities(applicationUser.getPermissions()));

    return new User(applicationUser.getUsername(), applicationUser.getPassword(), authorities);
  }

  private List<GrantedAuthority> getAuthorities(Set<PermissionEntity> permissions) {

    List<GrantedAuthority> authorities = new ArrayList<>();

    permissions.forEach(
        (role) -> {
          authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

    return authorities;
  }
}

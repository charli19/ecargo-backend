package com.iceond.ecargo.controller;

import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLConstant.USERS)
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  //@PreAuthorize("hasAuthority('user')")
  public List<UserEntity> getUsers(Principal principal) {
    return this.userService.getUsers();
  }

}
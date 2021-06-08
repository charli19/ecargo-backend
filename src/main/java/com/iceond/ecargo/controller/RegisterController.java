package com.iceond.ecargo.controller;

import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("RegisterController")
@RequestMapping(value = URLConstant.REGISTER, produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

  private UserService userService;

  @Autowired
  public RegisterController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public void createUser(@RequestBody UserEntity userEntity) {

    userService.createUser(userEntity);
  }
}

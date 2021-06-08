package com.iceond.ecargo.controller;
import com.iceond.ecargo.common.URLConstant;
import com.iceond.ecargo.entity.AddressEntity;
import com.iceond.ecargo.entity.UserEntity;
import com.iceond.ecargo.service.UserService;
import com.iceond.ecargo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = URLConstant.ADDRESS)
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class AddressController {

  private final UserService userService;
  private final AddressService addressService;

  @Autowired
  public AddressController(AddressService addressService, UserService userService) {

    this.addressService = addressService;
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  //@PreAuthorize("hasAuthority('user')")
  public List<AddressEntity> getAddressesByUserId(@PathVariable("userId") long userId) {
    return this.addressService.getAddressesByUserId(userId);
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public void createAddress(Principal principal, @RequestBody AddressEntity addressEntity) {

    UserEntity user = this.userService.getUser(principal.getName());

    addressEntity.setUser(user);

    this.addressService.createAddress(addressEntity);
  }

  @DeleteMapping(value="/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
  //@PreAuthorize("hasAuthority('user')")
  public void deleteAddress(@PathVariable("addressId") long addressId) {
    this.addressService.deleteAddress(addressId);
  }

}
package com.iceond.ecargo.service;

import com.iceond.ecargo.entity.AddressEntity;

import java.util.List;

public interface AddressService {

  List<AddressEntity> getAddressesByUserId(Long user_id);

  void createAddress(AddressEntity addressEntity);

  void deleteAddress(long addressId);
}

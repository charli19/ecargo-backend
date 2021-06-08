package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.AddressEntity;
import com.iceond.ecargo.service.AddressService;
import com.iceond.ecargo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  @Autowired
  public AddressServiceImpl(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @Override
  public List<AddressEntity> getAddressesByUserId(Long user_id) {

    return this.addressRepository.findAll();
  }


  @Override
  public void createAddress(AddressEntity addressEntity) {

    this.addressRepository.save(addressEntity);
  }

  @Override
  public void deleteAddress(long addressId) {
    this.addressRepository.deleteById(addressId);

  }
}
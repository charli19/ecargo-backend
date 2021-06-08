package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.entity.StatusEntity;
import com.iceond.ecargo.repository.StatusRepository;
import com.iceond.ecargo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

  private final StatusRepository statusRepository;

  @Autowired
  public StatusServiceImpl(StatusRepository statusRepository) {
    this.statusRepository = statusRepository;
  }

  @Override
  public StatusEntity findByName(String name) {

    return this.statusRepository.findByName(name);
  }
}

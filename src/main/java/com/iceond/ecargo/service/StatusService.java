package com.iceond.ecargo.service;

import com.iceond.ecargo.entity.StatusEntity;

public interface StatusService {

  StatusEntity findByName(String name);
}

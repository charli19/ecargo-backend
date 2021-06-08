package com.iceond.ecargo.service.impl;

import com.iceond.ecargo.service.LocationService;
import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {


  @Override
  public double getKmBetween(double lat1, double lon1, double lat2, double lon2) {

    return SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);

  }
}
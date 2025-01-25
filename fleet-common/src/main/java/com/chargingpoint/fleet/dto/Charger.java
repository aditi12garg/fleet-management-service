package com.chargingpoint.fleet.dto;

public class Charger {

  int id;
  double chargingRate;

  public Charger(int id, double chargingRate) {
    this.id = id;
    this.chargingRate = chargingRate;
  }

  public int getId() {
    return id;
  }

  public double getChargingRate() {
    return chargingRate;
  }
}

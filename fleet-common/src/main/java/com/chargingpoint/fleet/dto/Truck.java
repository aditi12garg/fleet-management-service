package com.chargingpoint.fleet.dto;


public class Truck {

  int id;
  double batteryCapacity;
  double currentCharge;

  public Truck(int id, double batteryCapacity, double currentCharge) {
    this.id = id;
    this.batteryCapacity = batteryCapacity;
    this.currentCharge = currentCharge;
  }

  public int getId() {
    return id;
  }

  public double getBatteryCapacity() {
    return batteryCapacity;
  }

  public double getCurrentCharge() {
    return currentCharge;
  }

  public Double chargeRequired() {
    return batteryCapacity - currentCharge;
  }
}

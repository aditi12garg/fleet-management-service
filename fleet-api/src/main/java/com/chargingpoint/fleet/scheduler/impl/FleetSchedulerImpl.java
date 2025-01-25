package com.chargingpoint.fleet.scheduler.impl;

import com.chargingpoint.fleet.dto.Charger;
import com.chargingpoint.fleet.dto.Truck;
import com.chargingpoint.fleet.scheduler.FleetScheduler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FleetSchedulerImpl implements FleetScheduler {


  @Override
  public Map<Integer, List<Integer>> scheduleFleet(List<Truck> trucks, List<Charger> chargers, double availableTime) {
    trucks.sort(Comparator.comparingDouble(Truck::chargeRequired));
    chargers.sort(Comparator.comparingDouble(Charger::getChargingRate).reversed());
    Map<Integer, Double> chargerTimeLeft = new HashMap();
    chargers.stream().forEach(chargerId -> chargerTimeLeft.put(chargerId.getId(), availableTime));
    Map<Integer, List<Integer>> scheduleChargesData = new HashMap<>();
    for (Truck truck : trucks) {
      for (Charger charger : chargers) {
        double timeToCharge = truck.chargeRequired() / charger.getChargingRate();
        if (chargerTimeLeft.get(charger.getId()) >= timeToCharge) {
          scheduleChargesData.putIfAbsent(charger.getId(), new ArrayList<>());
          scheduleChargesData.get(charger.getId()).add(truck.getId());

          // Update the remaining time for the charger
          chargerTimeLeft.put(charger.getId(), chargerTimeLeft.get(charger.getId()) - timeToCharge);
          break;
        }
      }
    }
    return scheduleChargesData;
  }
}

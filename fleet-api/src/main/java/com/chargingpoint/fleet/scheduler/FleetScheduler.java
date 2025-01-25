package com.chargingpoint.fleet.scheduler;

import com.chargingpoint.fleet.dto.Charger;
import com.chargingpoint.fleet.dto.Truck;
import java.util.List;
import java.util.Map;

public interface FleetScheduler {

  /*
  This defines the method to schedule charging stations for fleet
  */
  Map<Integer, List<Integer>> scheduleFleet(List<Truck> trucks, List<Charger> chargers, double availableTime);

}

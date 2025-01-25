package com.chargingpoint.fleet.application;

import com.chargingpoint.fleet.dto.Charger;
import com.chargingpoint.fleet.dto.Truck;
import com.chargingpoint.fleet.scheduler.FleetScheduler;
import com.chargingpoint.fleet.scheduler.impl.FleetSchedulerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FleetSchedulerApplication {

  public static void main(String[] args)
  {
    FleetScheduler scheduler = new FleetSchedulerImpl();
    List<Truck> trucks = new ArrayList<>();
    trucks.add(new Truck(1, 50, 10)); // Truck 1: Needs 40kWh more
    trucks.add(new Truck(2, 80, 20)); // Truck 2: Needs 60kWh more
    trucks.add(new Truck(3, 60, 30)); // Truck 3: Needs 30kWh more
    trucks.add(new Truck(4, 100, 50)); // Truck 4: Needs 50kWh more

    // Define chargers with ID and charging rate in kW
    List<Charger> chargers = new ArrayList<>();
    chargers.add(new Charger(1, 10));
    chargers.add(new Charger(2, 20));

    // Available time for charging (in hours)
    int availableTime = 5; // 5 hours to charge
    Map<Integer, List<Integer>> scheduleChargesData = scheduler.scheduleFleet(trucks, chargers, availableTime);
    scheduleChargesData.forEach((chargerId, truckIds) -> {
      System.out.println("Charger " + chargerId + ": " + truckIds.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    });
  }
}

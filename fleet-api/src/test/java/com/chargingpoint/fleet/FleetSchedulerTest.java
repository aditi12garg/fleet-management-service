package com.chargingpoint.fleet;


import com.chargingpoint.fleet.dto.Charger;
import com.chargingpoint.fleet.dto.Truck;
import com.chargingpoint.fleet.scheduler.FleetScheduler;
import com.chargingpoint.fleet.scheduler.impl.FleetSchedulerImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class FleetSchedulerTest {

  @Test
  public void test() {
    FleetScheduler fleetScheduler = new FleetSchedulerImpl();
    List<Truck> trucks = new ArrayList<>();
    trucks.add(new Truck(1, 50, 10));
    trucks.add(new Truck(2, 80, 50));
    trucks.add(new Truck(3, 60, 30));
    trucks.add(new Truck(4, 100, 90));

    List<Charger> chargers = new ArrayList<>();
    chargers.add(new Charger(1, 10)); // Charger 1: 10kW
    chargers.add(new Charger(2, 20)); // Charger 2: 20kW

    Map<Integer, List<Integer>> expectedScheduleChargesData = new HashMap<>();
    expectedScheduleChargesData.put(1, Arrays.asList(1));
    expectedScheduleChargesData.put(2, Arrays.asList(4, 2, 3));
    int availableTime = 5;
    Map<Integer, List<Integer>> scheduleChargesData = fleetScheduler.scheduleFleet(trucks, chargers, availableTime);
    Assert.assertEquals(scheduleChargesData, expectedScheduleChargesData);
  }

}

package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private int actualCapacity;
    private List vehicles;
    private List<ParkingLotObserver> observers;


    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void registeredObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }



    public void vehicleParking(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer: observers) {
                observer.capacityIsFull();

            }

            throw new ParkingLotException("Parking Lot is Full.");
        }
        if (isVehicleParked(vehicle))
            throw  new ParkingLotException("Vehicle is already parked");
        this.vehicles.add(vehicle);

    }

    public void vehicleUnParking(Object  vehicle) throws ParkingLotException {
        if (this.vehicles != null)
            throw new ParkingLotException("Parking Lot is Full.");
        if (this.vehicles.contains(vehicle) ) {
            this.vehicles.remove(vehicle);
            throw new ParkingLotException("Parking Lot is Empty");
        }
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    public boolean isVehicleUnParked(Object vehicle) {
        if (vehicle == null)
            return false;
        if (this.vehicles.contains(vehicle)){
            this.vehicles.remove(vehicle);
            return true;
        }
        return false;
    }



}

/*
* public class Demo {

  public int getDemo(int length) {
    if(length>0) {
      return 10;
    } else {
      throw new RuntimeException("Test Exception");
    }
  }

}
@Test
  void whenGetDemoCalledAndPass5_shouldReturnPositiveValue() {
    Demo demo = new Demo();
    assertEquals(10, demo.getDemo(5));
  }

  @Test
  void getDemoTest() {
    Demo demo = new Demo();
    assertThrows(RuntimeException.class, ()-> demo.getDemo(0));
  }*/

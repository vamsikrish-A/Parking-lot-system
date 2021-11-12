package com.bridgelabz;

public class ParkingLotSystem {

    private final int actualCapacity;
    private int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void registeredOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }


    public void vehicleParking(Object vehicle) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Parking Lot is Full.");
        }
        this.currentCapacity++;
        this.vehicle = vehicle;

    }

    public void vehicleUnParking(Object  vehicle) throws ParkingLotException {
        if (this.vehicle != null)
            throw new ParkingLotException("Parking Lot is Full.");
        if (this.vehicle.equals(vehicle) ) {
            vehicle = null;
            throw new ParkingLotException("Parking Lot is Empty");
        }
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicle != null)
            return false;
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean isVehicleUnParked(Object vehicle) {
        if (this.vehicle != null)
            return false;
        if (this.vehicle.equals(vehicle)){
            vehicle = null;
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

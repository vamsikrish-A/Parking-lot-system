package com.bridgelabz;

public class AirportSecurity implements ParkingLotObserver{
    private boolean isFullCapacity;

    public void capacityIsFull() {
        isFullCapacity = true;
    }

    @Override
    public void capacityIsAvailable() {
        isFullCapacity = false;
    }

    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}

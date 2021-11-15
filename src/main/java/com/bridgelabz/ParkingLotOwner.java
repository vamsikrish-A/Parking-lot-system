package com.bridgelabz;

/**********************************
 * @purpose: Parking Lot Owner observers the parking lot capacity to put out the full sign.
 *
 * @author : VamsiKrishna A
 * ********************************/

public class ParkingLotOwner implements ParkingLotObserver {


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

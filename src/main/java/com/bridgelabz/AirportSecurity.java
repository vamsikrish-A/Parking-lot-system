package com.bridgelabz;

/**********************************
 * @purpose: Airport Security observers the parking lot capacity to redirect staff.
 *
 * @author : VamsiKrishna A
 * ********************************/
public class AirportSecurity implements ParkingLotObserver {
    private boolean isFullCapacity;

    /*
     * @purpose: Override Methods to check the parking lot capacity
     *  */
    @Override
    public void capacityIsFull() {
        isFullCapacity = true;
    }

    @Override
    public void capacityIsAvailable() {
        isFullCapacity = false;
    }

    /*
     * @purpose: method returns boolean value of the parking lot capacity as true or false
     * */
    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}

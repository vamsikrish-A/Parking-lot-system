package com.bridgelabz;

public class ParkingLotSystem {

    private Object vehicle;

    public boolean vehicleParking(Object vehicle) {
        if (this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    public boolean vehicleUnParking(Object  vehicle) {
        if (this.vehicle.equals(vehicle) ) {
            vehicle = null;
            return true;
        }
        return false;
    }
}

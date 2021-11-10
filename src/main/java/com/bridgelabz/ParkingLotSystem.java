package com.bridgelabz;

public class ParkingLotSystem {

    private Object vehicle;

    public boolean vehicleParking(Object vehicle) {
        this.vehicle = vehicle;
        return true;
    }

    public boolean vehicleUnParking(Object  vehicle) {
        if (this.vehicle == vehicle) {
            vehicle = null;
            return true;
        }
        return false;
    }
}

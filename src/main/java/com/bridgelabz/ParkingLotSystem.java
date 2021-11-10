package com.bridgelabz;

public class ParkingLotSystem {

    private Object vehicle;

    public void vehicleParking(Object vehicle) throws ParkingLotException {
        if (this.vehicle != null)
            throw  new ParkingLotException("Parking Lot is Full.");
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

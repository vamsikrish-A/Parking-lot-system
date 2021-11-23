package com.bridgelabz;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpot {

    private List<Vehicle> vehicles;
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem(2);
    private Object vehicle;

    public Object parkingSpotForVehicleParking() throws ParkingLotException {
        vehicles = new ArrayList<>();
        vehicle = new Object();
        if (vehicles.equals(parkingLotSystem.isVehicleParked(vehicle))) {
            int parkingSlotNumber = this.vehicles.indexOf(vehicle);
            return parkingSlotNumber;
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,
                "No Such vehicle in parking lot");
    }
}



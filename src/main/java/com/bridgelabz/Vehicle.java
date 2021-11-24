package com.bridgelabz;

import java.time.LocalTime;

public class Vehicle{
    private final String vehicleType;
    private LocalTime parkingTime;

    public Vehicle(String vehicleType, LocalTime parkingTime) {
        this.vehicleType = vehicleType;
        this.parkingTime = parkingTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public LocalTime getParkingTime() {
        return parkingTime;
    }
}

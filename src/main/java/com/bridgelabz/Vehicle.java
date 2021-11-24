package com.bridgelabz;

import java.time.LocalTime;

public class Vehicle{
    private final String vehicleType;
    private LocalTime parkingTime;
    private  String vehicleColor;

    public enum DriverType {NORMAL , HANDICAPPED;

        public static boolean HANDICAPPED(Vehicle vehicle) {
            return true;
        }
    }
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

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleColor() { return vehicleColor; }
}

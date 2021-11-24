package com.bridgelabz;

import java.time.LocalTime;

public class Vehicle{
    private final String vehicleType;
    private LocalTime parkingTime;
    private  String vehicleColor;
    private  String vehicleBrand;
    private String  vehicleNumber;

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

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

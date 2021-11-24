package com.bridgelabz;
/********************************************************************
 * @purpose: to store vehicle details.
 *
 * @author: VamsiKrishna A
 * @version: 1.0
 * @since:19-November-2021
 * *******************************************************************/

import java.time.LocalTime;

public class Vehicle {

    private String vehicleType;
    private LocalTime parkingTime;
    private String vehicleColor;
    private String vehicleBrand;
    private String vehicleNumber;

    /*
     * Constructors for vehicle attributes  */
    public Vehicle(String vehicleType, LocalTime parkingTime) {
        this.vehicleType = vehicleType;
        this.parkingTime = parkingTime;
    }

    /*
     * Getters and Setters for vehicleType, ParkingTime, vehicleColor, vehicleBrand ,vehicleNumber
     * */
    public String getVehicleType() {
        return vehicleType;
    }

    public LocalTime getParkingTime() {
        return parkingTime;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

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

    public enum DriverType {
        NORMAL, HANDICAPPED;

        public static boolean HANDICAPPED(Vehicle vehicle) {
            return true;
        }
    }
}

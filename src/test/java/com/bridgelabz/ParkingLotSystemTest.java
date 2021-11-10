package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {
    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeFalse() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        boolean Park = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(Park);

    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        boolean Park = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(Park);

    }

    @Test
    public void givenCarToParkingLot_WhenDriverWantToUnParkTheCar_ShouldReturnFalse() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        boolean unParkVehicle = parkingLotSystem.vehicleUnParking(vehicle);
        Assertions.assertTrue(unParkVehicle);
    }
    @Test
    public void givenCarToParkingLot_WhenDriverWantsToUnParkTheCar_ShouldReturnTrue() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        boolean unParkVehicle = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(unParkVehicle);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnFalse() {
        Object vehicle = new Object();
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        parkingLotSystem.vehicleParking(vehicle);
        boolean unParking = parkingLotSystem.vehicleUnParking(vehicle);
        Assertions.assertTrue(unParking);
    }
}

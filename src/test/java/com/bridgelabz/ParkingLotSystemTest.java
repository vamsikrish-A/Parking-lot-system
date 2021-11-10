package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {

    ParkingLotSystem parkingLotSystem = null;
    Object vehicle = null;

    @BeforeEach
    public void setUp() {
        parkingLotSystem = new ParkingLotSystem();
        vehicle = new Object();
    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeFalse() {
        try {
            parkingLotSystem.vehicleParking(vehicle);
            boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertFalse(isParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        try {
             parkingLotSystem.vehicleParking(vehicle);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking is full", e.getMessage());
            e.printStackTrace();
        }

    }


    @Test
    public void givenCarToParkingLot_WhenDriverWantsToUnParkTheCar_ShouldReturnTrue() {
        try {
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleUnParking(vehicle);
            boolean vehicleUnParked = parkingLotSystem.isVehicleUnParked(vehicle);
            Assertions.assertTrue(vehicleUnParked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnFalse() {
        try {
            parkingLotSystem.vehicleParking(vehicle);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        try {
             parkingLotSystem.vehicleUnParking(vehicle);
             parkingLotSystem.isVehicleUnParked(vehicle);

        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot is Full.", e.getMessage());

            e.printStackTrace();
        }
    }
}

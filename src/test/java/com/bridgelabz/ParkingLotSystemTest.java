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
        parkingLotSystem.vehicleParking(vehicle);
        boolean Park = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertFalse(Park);

    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        boolean Park = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(Park);

    }

    @Test
    public void givenCarToParkingLot_WhenDriverWantToUnParkTheCar_ShouldReturnFalse() {
        parkingLotSystem.vehicleUnParking(vehicle);
        boolean unParkVehicle = parkingLotSystem.vehicleUnParking(vehicle);
        Assertions.assertFalse(unParkVehicle);
    }
    @Test
    public void givenCarToParkingLot_WhenDriverWantsToUnParkTheCar_ShouldReturnTrue() {
        boolean unParkVehicle = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(unParkVehicle);
    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
        parkingLotSystem.vehicleParking(vehicle);
        boolean unParking = parkingLotSystem.vehicleUnParking(vehicle);
        Assertions.assertTrue(unParking);
    }
}

package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotSystemTest {
    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Object vehicle = new Object();
        boolean Park = parkingLotSystem.vehicleParking(vehicle);
        Assertions.assertTrue(Park);

    }
}

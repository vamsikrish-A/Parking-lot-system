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
        parkingLotSystem = new ParkingLotSystem(2);
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

    @Test
    public void givenVehiclesToParkingLot_WhenTheLotIsFull_ShouldReturnFullSign() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredOwner(owner);
        try {
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(new Object());
        } catch (ParkingLotException e) { }
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertTrue(capacityFull);


    }
    @Test
    public void givenCapacityIs2_ShouldBeAbleToPrk2Vehicles() {
        Object vehicle2 = new Object();
        parkingLotSystem.setCapacity(2);
        try {
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(vehicle2);
            boolean isParked1 = parkingLotSystem.isVehicleParked(vehicle);
            boolean isParked2 = parkingLotSystem.isVehicleParked(vehicle2);
            Assertions.assertTrue(isParked1 && isParked2);
        } catch (ParkingLotException e) { }
    }

    @Test
    public void givenParkingLotIsFull_ShouldReturnToAirportSecurity() throws ParkingLotException {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredOwner(owner);
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.registeredSecurity(airportSecurity);
        Assertions.assertDoesNotThrow(()-> {
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(new Object());
        });
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assertions.assertTrue(capacityFull);
    }
}

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
        parkingLotSystem = new ParkingLotSystem(1);
        vehicle = new Object();
    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar() {
        Assertions.assertDoesNotThrow(()->{
            parkingLotSystem.vehicleParking(vehicle);
        });
        boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
        Assertions.assertTrue(isParked);


    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        Assertions.assertDoesNotThrow(()->{
            parkingLotSystem.vehicleParking(vehicle);
        });
        boolean isParked = parkingLotSystem.isVehicleParked(vehicle);

        Assertions.assertTrue(isParked);

    }


    @Test
    public void givenCarToParkingLot_WhenDriverWantsToUnParkTheCar_ShouldReturnTrue() {
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleUnParking(vehicle);
            boolean vehicleUnParked = parkingLotSystem.isVehicleUnParked(vehicle);
            Assertions.assertTrue(vehicleUnParked);
        });

    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnFalse() {
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleUnParking(vehicle);
            parkingLotSystem.isVehicleUnParked(vehicle);
        },"Parking Lot is Full.");

    }

    @Test
    public void givenVehiclesToParkingLot_WhenTheLotIsFull_ShouldReturnFullSign() {
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredObserver(owner);
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(new Object());
            parkingLotSystem.vehicleParking(new Object());
        },"Parking lot is full.");
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertTrue(capacityFull);


    }
    @Test
    public void givenCapacityIs2_ShouldBeAbleToPrk2Vehicles() {
        parkingLotSystem.setCapacity(2);
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(vehicle);
            boolean isParked1 = parkingLotSystem.isVehicleParked(vehicle);
            boolean isParked2 = parkingLotSystem.isVehicleParked(vehicle);
            Assertions.assertTrue(isParked1 && isParked2);

        });

    }

    @Test
    public void givenParkingLotIsFull_ShouldReturnToAirportSecurity()  {
//        ParkingLotOwner owner = new ParkingLotOwner();
//        parkingLotSystem.registeredObserver(owner);
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.registeredObserver(airportSecurity);
        Assertions.assertThrows(ParkingLotException.class,()-> {
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(new Object());
        },"Parking Lot is Full.");
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assertions.assertTrue(capacityFull);
    }
    @Test
    public void givenWhenParkingLotSpaceIsAvailableAfterFull_ShouldReturnTrue() {
        Object vehicle2 = new Object();
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredObserver(owner);
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            parkingLotSystem.vehicleParking(vehicle2);
        },"Parking lot is full.");
        parkingLotSystem.isVehicleUnParked(vehicle);
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertFalse(capacityFull);
    }
}

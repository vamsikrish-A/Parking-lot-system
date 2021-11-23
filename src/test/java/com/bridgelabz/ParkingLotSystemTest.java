package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

public class ParkingLotSystemTest {

    ParkingLotSystem parkingLotSystem = null;
    Vehicle vehicles = null;
    Object vehicle = null;
    LocalTime time = LocalTime.now();

    @BeforeEach
    public void setUp() {
        parkingLotSystem = new ParkingLotSystem(1);
        vehicle = new Object();
    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar() {
        vehicles = new Vehicle("car", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class,() -> {
            parkingLotSystem.vehicleParking(vehicles);
        });
        boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
        Assertions.assertFalse(isParked);
    }

    @Test
    public void givenCarToParkingLot_WhenDriverAbleToParkTheCar_ShouldBeTrue() {
        vehicles = new Vehicle("car", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class,() -> {
            parkingLotSystem.vehicleParking(vehicles);
        });
        boolean isParked = parkingLotSystem.isVehicleParked(vehicles);
        Assertions.assertTrue(isParked);
    }


    @Test
    public void givenCarToParkingLot_WhenDriverWantsToUnParkTheCar_ShouldReturnTrue() {
        vehicles = new Vehicle("car", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleUnParking(vehicles);
            boolean vehicleUnParked = parkingLotSystem.isVehicleUnParked(vehicles);
            Assertions.assertTrue(vehicleUnParked);
        });

    }

    @Test
    public void givenAVehicle_WhenUnParked_ShouldReturnFalse() {
        vehicles = new Vehicle("car", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleUnParking(vehicles);
            parkingLotSystem.isVehicleUnParked(vehicles);
        }, "Parking Lot is Full.");

    }

    @Test
    public void givenVehiclesToParkingLot_WhenTheLotIsFull_ShouldReturnFullSign() {
        vehicles = new Vehicle("car", LocalTime.now());
        Vehicle vehicle1 = new Vehicle("suv", LocalTime.now());
        Vehicle vehicle2 = new Vehicle("xuv", LocalTime.now());
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredObserver(owner);
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleParking(vehicle1);
            parkingLotSystem.vehicleParking(vehicle2);
        }, "Parking lot is full.");
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertFalse(capacityFull);


    }

    @Test
    public void givenCapacityIs2_ShouldBeAbleToPrk2Vehicles() {
        vehicles = new Vehicle("suv", LocalTime.now());
        parkingLotSystem.setCapacity(2);
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleParking(vehicles);
            boolean isParked1 = parkingLotSystem.isVehicleParked(vehicles);
            boolean isParked2 = parkingLotSystem.isVehicleParked(vehicles);
            Assertions.assertTrue(isParked1 && isParked2);

        });

    }

    @Test
    public void givenParkingLotIsFull_ShouldReturnToAirportSecurity() {
//        ParkingLotOwner owner = new ParkingLotOwner();
//        parkingLotSystem.registeredObserver(owner);
        vehicles = new Vehicle("suv", LocalTime.now());
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.registeredObserver(airportSecurity);
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleParking(new Object());
        }, "Parking Lot is Full.");
        boolean capacityFull = airportSecurity.isCapacityFull();
        Assertions.assertFalse(capacityFull);
    }

    @Test
    public void givenWhenParkingLotSpaceIsAvailableAfterFull_ShouldReturnTrue() {
        vehicles = new Vehicle("suv", LocalTime.now());
        vehicles = new Vehicle("xuv", LocalTime.now());
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registeredObserver(owner);
        Assertions.assertThrows(ParkingLotException.class, () -> {
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.vehicleParking(vehicles);
        }, "Parking lot is full.");
        parkingLotSystem.isVehicleUnParked(vehicles);
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertFalse(capacityFull);
    }
    @Test
    public void givenParkedVehicle_WhenDriverWantsToFindThCar_ShouldReturnNotEqual() {
        vehicles = new Vehicle("suv", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.isVehicleParked(vehicles);
            int slotNumber = parkingLotSystem.findingVehicle(vehicles);
            Assertions.assertNotEquals(1, slotNumber);
        },"No Such vehicle in parking lot");
    }
    @Test
    public void givenParkedVehicle_WhenDriverWantsToFindThCar_ShouldReturnEqual() {
        vehicles = new Vehicle("xuv", LocalTime.now());
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicles);
            parkingLotSystem.isVehicleParked(vehicles);
            int slotNumber = parkingLotSystem.findingVehicle(vehicles);
            Assertions.assertEquals(0, slotNumber);
        },"No Such vehicle in parking lot");
    }
    @Test
    public void givenVehicleWhenParkingWantToKnowTimeShouldBeNotEqual() {
        Vehicle vehicle = new Vehicle("Car", LocalTime.now());
        ParkingSpot parkingSpot = new ParkingSpot();
        Assertions.assertThrows(ParkingLotException.class, ()->{
            parkingLotSystem.vehicleParking(vehicle);
            Assertions.assertEquals(1,parkingSpot.parkingSpotForVehicleParking());
        });
        LocalTime time = vehicle.getParkingTime();
        Assertions.assertNotEquals(time,LocalTime.now());
    }

}

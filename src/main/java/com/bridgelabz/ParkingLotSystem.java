package com.bridgelabz;
/********************************************************************
 * @purpose: Parking Lot System
 *
 * @author: VamsiKrishna A
* @version: 1.0
 * @since:10-November-2021
 * *******************************************************************/

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingLotSystem<slot> {

    /*
     * private variable is declared to get capacity of parking lot system to park the vehicles
     *  */
    private int actualCapacity;
    /*
     * private list for vehicles is declared to get all vehicles that has parked and unParked
     * in the system
     * */
    //private List<Vehicle> vehicles;
    /*
     * Private list for observers has declared to inform all the observers when the parking lot is full
     * as parking lot owner, Airport Security..
     * */
    private List<ParkingLotObserver> observers;
    private List<Vehicle> parkingLot1;
    private List<Vehicle> parkingLot2;
    private Vehicle vehicle;
    private List<Vehicle> handicappedParking;



    /*
     * Constructor for global variables,lists
     * */
    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
       // this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
        parkingLot1 = new ArrayList<>(actualCapacity);
        parkingLot2 = new ArrayList<>(actualCapacity);
        handicappedParking = new ArrayList<>(actualCapacity);

    }

    /*
     * @purpose: setCapacity method for setting the actual capacity of Parking Lot system
     * @params: capacity is used to set the actual Capacity of parking lot.
     * */
    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    /*
     * @purpose: registeredObserver method for registering the observers to parking lot
     * system is full or space availability as Parking lot owner, Airport Security
     * @params: observer interfaces as owner or security.
     * */
    public void registeredObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }

    /*
    * @purpose: method to park the vehicle in parking lot system
                by checking the space availability and checks for whether the same vehicle as parked
                 & throws exception when the lot or capacity is full.
    * @params: vehicle as object is used to check whether the same vehicle object present
    *           or adds to vehicles list to Park Vehicle.
    * */
    public void vehicleParking(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot1.size() == actualCapacity && parkingLot2.size() == actualCapacity
                && handicappedParking.size() == actualCapacity) {
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,"Parking lot is full.");
        }
        if (isVehicleParked(vehicle)) {
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARKED,
                    "Vehicle is already parked");
        }
        if (Vehicle.DriverType.HANDICAPPED(vehicle)){
            if (handicappedParking.size() > actualCapacity)
                throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,
                        "Parking lot is full.");
            handicappedParking.add(vehicle);
        }else if (vehicle.getVehicleType().equals("xuv")){                          //manoeuvre large cars
            if (parkingLot1.size() > parkingLot2.size()) {
                parkingLot2.add(vehicle);
            } else  parkingLot1.add(vehicle);
        }else {
            if (parkingLot1.size() > parkingLot2.size()) {
                parkingLot2.add(vehicle);
            } else  parkingLot1.add(vehicle);
        }
        if (parkingLot1.size() == actualCapacity || parkingLot2.size() == actualCapacity
                || handicappedParking.size() == actualCapacity) {
            for (ParkingLotObserver observer : observers) {
                observer.capacityIsFull();
            }
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,"Parking Lot is Full.");
        }

    }

    /*
    * @purpose: method t unPark a vehicle from the parking lot system , fist checks whether the lot is null
                & goes into the list contains(),contains() method use for checking specified element exists in given
                list or not , removes the vehicle from the list
    * @params: vehicle as object , checks for vehicle object present in vehicles List
    * */
    public void vehicleUnParking(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot1 != null || parkingLot2 != null)
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,"Parking Lot is Full.");
        if (parkingLot1.contains(vehicle)) {
            parkingLot1.remove(vehicle);
            throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,"Parking Lot is Empty");
        }
        if (parkingLot2.contains(vehicle)) {
            parkingLot2.remove(vehicle);
            throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,"Parking Lot is Empty");
        }
    }

    /*
     * @purpose: method used to add the vehicle object to list vehicles
     *           to park vehicles, returns True, if not returns False.
     * @params: vehicle as object checks whether contains in vehicles List.
     * */
    public boolean isVehicleParked(Vehicle vehicle) {
        for (Vehicle park : parkingLot1) {
            if (park.equals(vehicle)){
                return true;
            }
            break;
        }
        for (Vehicle park : parkingLot2) {
            if (park.equals(vehicle)) {
                return  true;
            }
            break;
        }
        for (Vehicle park : handicappedParking) {
            if (park.equals(vehicle)) {
                return true;
            }
            break;
        }

        return false;
    }

    /*
     * @purpose: method used to unPark the vehicle object form vehicles list
     *           checks whether the list is null, returns false,
     *           checks vehicles list contains vehicle object & removes it for list,
     *           observer shows the capacity of parking lot to observers.
     * @params: vehicle as object checks whether contains in vehicles List,
     *           if contains removes from the vehicle List.
     * */
    public boolean isVehicleUnParked(Vehicle vehicle) {
        if (parkingLot1 == null || parkingLot2 == null)
            return false;
        for(Vehicle vehicle1 : parkingLot1) {
            if (vehicle1.equals(vehicle)) {
                parkingLot1.remove(vehicle);
                for (ParkingLotObserver observer : observers) {
                    observer.capacityIsAvailable();
                }
                return true;
            }
        }
        for(Vehicle vehicle1 : parkingLot2) {
            if (vehicle1.equals(vehicle)) {
                parkingLot2.remove(vehicle);
                for (ParkingLotObserver observer : observers) {
                    observer.capacityIsAvailable();
                }
                return true;
            }
        }
        return false;
    }

    /*
    * @purpose: As driver wants to find the Parked car.
    *
    * @params: vehicle as object, finding a vehicle from list by using indexOf vehicles list
    * */
    public int findingVehicle(Vehicle vehicle) throws ParkingLotException {
        if (isVehicleParked(vehicle)){
            for (Vehicle slotNumber : parkingLot1) {
                if (slotNumber.equals(vehicle))
                    return parkingLot1.indexOf(slotNumber);
            }
            for (Vehicle slotNumber : parkingLot2) {
                if (slotNumber.equals(vehicle))
                    return parkingLot2.indexOf(slotNumber);
            }
            for (Vehicle slotNumber : handicappedParking) {
                if (slotNumber.equals(vehicle))
                    return handicappedParking.indexOf(slotNumber);
            }
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,
                "No Such vehicle in parking lot");
    }
    public int getVehicleLocationByColor(Vehicle vehicleColor) throws ParkingLotException {
        for (Vehicle whiteCar: parkingLot1) {
            if (whiteCar.getVehicleColor().equals(vehicleColor))
                return parkingLot1.indexOf(whiteCar);
        }
        for (Vehicle whiteCar : parkingLot2) {
            if (whiteCar.getVehicleColor().equals(vehicleColor))
                return parkingLot1.indexOf(whiteCar);
        }
        for (Vehicle whiteCar : handicappedParking) {
            if (whiteCar.getVehicleColor().equals(vehicleColor))
                return handicappedParking.indexOf(whiteCar);
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,"no such vehicle");
    }
    public String getBlueToyotaVehicleNumber(Vehicle vehicleBrand ,Vehicle vehicleColor) throws ParkingLotException {
        if (isVehicleParked(vehicle)) {
            if (vehicle.getVehicleBrand().equals(vehicleBrand) && vehicle.getVehicleColor().equals(vehicleColor)) {
                    for (Vehicle vNumber : parkingLot1) {
                        if (vNumber.equals(vehicle))
                            return vNumber.getVehicleNumber();
                    }
                    for (Vehicle vNumber : parkingLot2) {
                        if (vNumber.equals(vehicle))
                            return vNumber.getVehicleNumber();
                    }
                    for (Vehicle vNumber : handicappedParking) {
                        if (vNumber.equals(vehicle))
                            return vNumber.getVehicleNumber();
                    }
            }
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,"no such vehicle");
    }
    public int valetParkingForHigSecurity(Vehicle vehicleBrand) throws ParkingLotException {
        if (isVehicleParked(vehicle)) {
            if (vehicle.getVehicleBrand().equals(vehicleBrand)) {
                for (Vehicle slotNumber : parkingLot1) {
                    if (slotNumber.equals(vehicle))
                        return parkingLot1.indexOf(slotNumber);
                }
                for (Vehicle slotNumber : parkingLot2) {
                    if (slotNumber.equals(vehicle))
                        return parkingLot2.indexOf(slotNumber);
                }
                for (Vehicle slotNumber : handicappedParking) {
                    if (slotNumber.equals(vehicle))
                        return handicappedParking.indexOf(slotNumber);
                }
            }
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,
                "No Such vehicle in parking lot");
    }
    public int getListOfLast30MinutesParkedVehicle(LocalTime time) throws ParkingLotException {
        if (isVehicleParked(vehicle)) {
            for (Vehicle car : parkingLot1) {
                if (car.getParkingTime().minusMinutes(30).equals(time))
                    return parkingLot1.indexOf(car);
            }
            for (Vehicle car : parkingLot2) {
                if (car.getParkingTime().minusMinutes(30).equals(time))
                    return parkingLot2.indexOf(car);
            }
            for (Vehicle car : handicappedParking) {
                if (car.getParkingTime().minusMinutes(30).equals(time))
                    return handicappedParking.indexOf(car);
            }
        }
        throw new ParkingLotException(ParkingLotException.ExceptionType.NO_SUCH_VEHICLE,"no such vehicle");
    }
    public boolean validatingVehicleNumberPlate(String vehicleNumber) {

        Pattern pattern = Pattern.compile("^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$");
        Matcher matcher = pattern.matcher(vehicleNumber);
        boolean value = matcher.matches();
        if ((vehicleNumber).isEmpty())
            return false;
        return value;

    }


}

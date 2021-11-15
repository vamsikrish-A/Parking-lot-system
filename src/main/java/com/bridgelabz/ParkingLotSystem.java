package com.bridgelabz;
/********************************************************************
 * @purpose: Parking Lot System
 *
 * @author: VamsiKrishna A
 * @version: 1.0
 * @since:10-November-2021
 * *******************************************************************/

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    /*
     * private variable is declared to get capacity of parking lot system to park the vehicles
     *  */
    private int actualCapacity;
    /*
     * private list for vehicles is declared to get all vehicles that has parked and unParked
     * in the system
     * */
    private List vehicles;
    /*
     * Private list for observers has declared to inform all the observers when the parking lot is full
     * as parking lot owner, Airport Security..
     * */
    private List<ParkingLotObserver> observers;


    /*
     * Constructor for global variables,lists
     * */
    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    /*
     * @purpose: setCapacity method for setting the actual capacity of Parking Lot system
     * @params: capacity is given in test cases.
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
    * @params: vehicle as object .
    * */
    public void vehicleParking(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer : observers) {
                observer.capacityIsFull();

            }

            throw new ParkingLotException("Parking Lot is Full.");
        }
        if (isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle is already parked");
        this.vehicles.add(vehicle);

    }

    /*
    * @purpose: method t unPark a vehicle from the parking lot system , fist checks whether the lot is null
                & goes into the list contains , removes the vehicle from the list
    * @params: vehicle as object
    * */
    public void vehicleUnParking(Object vehicle) throws ParkingLotException {
        if (this.vehicles != null)
            throw new ParkingLotException("Parking Lot is Full.");
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            throw new ParkingLotException("Parking Lot is Empty");
        }
    }

    /*
     * @purpose: method used to add the vehicle object to list vehicles
     *           to park vehicles, returns True, if not returns False.
     * @params: vehicle as object.
     * */
    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    /*
     * @purpose: method used to unPark the vehicle object form vehicles list
     *           checks whether the list is null, returns false,
     *           checks vehicles list contains vehicle object & removes it for list,
     *           observer shows the capacity of parking lot to observers.
     * @params: vehicle as object. */
    public boolean isVehicleUnParked(Object vehicle) {
        if (this.vehicles == null)
            return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            for (ParkingLotObserver observer : observers) {
                observer.capacityIsAvailable();

            }
            return true;
        }
        return false;
    }


}

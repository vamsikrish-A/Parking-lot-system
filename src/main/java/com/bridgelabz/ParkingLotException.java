package com.bridgelabz;

/*
 * @purpose: custom exceptions used to maintain the flow of the program.
 * @author: VamsiKrishna A
 * */
public class ParkingLotException extends Exception {
    private  final ExceptionType exceptionType;

    public enum ExceptionType {PARKING_LOT_IS_FULL, NO_SUCH_VEHICLE, VEHICLE_ALREADY_PARKED}
    public ParkingLotException(ExceptionType exceptionType, String message) {

        super(message);
        this.exceptionType = exceptionType;
    }
}

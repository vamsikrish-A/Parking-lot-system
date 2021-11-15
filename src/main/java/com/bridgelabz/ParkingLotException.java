package com.bridgelabz;

/*
 * @purpose: custom exceptions used to maintain the flow of the program.
 * @author: VamsiKrishna A
 * */
public class ParkingLotException extends Exception {
    public ParkingLotException(String message) {
        super(message);
    }
}

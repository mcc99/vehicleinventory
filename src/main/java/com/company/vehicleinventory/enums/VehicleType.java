package com.company.vehicleinventory.enums;

/**
 * Represents a vehicle type.  toString() and convert() are in essence stubs to
 * handle custom conversions when needed.
 */
public enum VehicleType {
    CAR, TRUCK, AIRPLANE, DRONE, AMPHIBIAN, BOAT;


    public String toString(){
        String retn = "";
        if (this == CAR) {
            retn = "CAR";
        }
        if (this == TRUCK) {
            retn = "TRUCK";
        }
        if (this == AIRPLANE) {
            retn = "AIRPLANE";
        }
        if (this == DRONE) {
            retn = "DRONE";
        }
        if (this == AMPHIBIAN) {
            retn = "AMPHIBIAN";
        }
        if (this == BOAT) {
            retn = "BOAT";
        }
        return retn;
    }

    public static VehicleType convert(String code) {
        VehicleType retn = null;
        if(code.equalsIgnoreCase("CAR")) {
            retn = CAR;
        }
        if(code.equalsIgnoreCase("TRUCK")) {
            retn = TRUCK;
        }
        if(code.equalsIgnoreCase("AIRPLANE")) {
            retn = AIRPLANE;
        }
        if(code.equalsIgnoreCase("DRONE")) {
            retn = DRONE;
        }
        if(code.equalsIgnoreCase("AMPHIBIAN")) {
            retn = AMPHIBIAN;
        }
        if(code.equalsIgnoreCase("BOAT")) {
            retn = BOAT;
        }
        return retn;
    }

}

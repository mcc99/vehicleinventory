package com.company.vehicleinventory.exceptions;

/**
 * Custom exception.  It would enclose the error class also defined if used.  Currently not used but
 * custom exceptions like these are common practice.
 */
public class VehicleInventoryException extends Exception {

    VehicleInventoryError vehicleInventoryError = null;

    public VehicleInventoryException() {
    }

    public VehicleInventoryException(String message) {
        super(message);
    }


    public void setVehicleInventoryError(VehicleInventoryError vehicleInventoryError) {
        this.vehicleInventoryError = vehicleInventoryError;
    }

    public VehicleInventoryError getVehicleInventoryError() {
        return vehicleInventoryError;
    }

}

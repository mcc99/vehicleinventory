package com.rackspace.vehicleinventory.enums;

/**
 * Represents db action status codes.  toString() and convert() are in essence stubs to
 * handle custom conversions when needed.
 */
public enum VehicleInventoryDatabaseStatusCode {
    ADDED,
    DELETED,
    UPDATED,
    FAILED;


    public String toString(){
      String retn = "";
      if (this == ADDED) {
          retn = "ADDED";
      }
      if (this == DELETED) {
          retn = "DELETED";
      }
      if (this == UPDATED) {
          retn = "UPDATED";
      }
      if (this == FAILED) {
          retn = "FAILED";
      }
      return retn;
    }

    public static VehicleInventoryDatabaseStatusCode convert(String code) {
        VehicleInventoryDatabaseStatusCode retn = null;
        if(code.equalsIgnoreCase("added")) {
            retn = ADDED;
        }
        if(code.equalsIgnoreCase("deleted")) {
            retn = DELETED;
        }
        if(code.equalsIgnoreCase("updated")) {
            retn = UPDATED;
        }
        if(code.equalsIgnoreCase("failed")) {
            retn = FAILED;
        }
        return retn;
    }

}

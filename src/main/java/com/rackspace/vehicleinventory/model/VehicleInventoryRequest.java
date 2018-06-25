package com.rackspace.vehicleinventory.model;


import com.rackspace.vehicleinventory.enums.VehicleType;

public class VehicleInventoryRequest {

    private String vin;
    private String currVin;
    private String make;
    private String model;
    private Integer year;
    private Boolean isUsed = false;
    private VehicleType type;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCurrVin() {
        return currVin;
    }

    public void setCurrVin(String currVin) {
        this.currVin = currVin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getType() {
        return type.name();
    }

    public void setType(String type) {
        this.type = VehicleType.valueOf(type);
    }

}

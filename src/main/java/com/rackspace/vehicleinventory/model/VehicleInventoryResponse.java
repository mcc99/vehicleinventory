package com.rackspace.vehicleinventory.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rackspace.vehicleinventory.persistence.VehicleInventory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a serializable collection of vehicles that can be returned as a default list load
 * or as a search result.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="response", propOrder= {"vehicles"})
@JsonPropertyOrder({ "vehicles" } )
public class VehicleInventoryResponse {

    List<VehicleInventory> vehicles = new ArrayList<VehicleInventory>();

    public void setVehicles(List<VehicleInventory> vehicles) {
        this.vehicles = vehicles;
    }

    public List<VehicleInventory> getVehicles() {
        return vehicles;
    }

}

package com.rackspace.vehicleinventory.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rackspace.vehicleinventory.enums.VehicleInventoryDatabaseStatusCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Represents a serializable status result for various actions performed.  Somewhat misnamed,
 * though arguably any change to a database is "saving" the database state.  That's a stretch though.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {"status"})
@JsonPropertyOrder({"status"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleInventorySaveResponse {

    private VehicleInventoryDatabaseStatusCode status = null;

    public void setStatus(VehicleInventoryDatabaseStatusCode status) {
        this.status = status;
    }

    public VehicleInventoryDatabaseStatusCode getStatus() {
        return status;
    }


}



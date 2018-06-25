package com.rackspace.vehicleinventory.interfaces;

import com.rackspace.vehicleinventory.exceptions.VehicleInventoryException;
import com.rackspace.vehicleinventory.model.VehicleInventoryRequest;
import com.rackspace.vehicleinventory.model.VehicleInventoryResponse;
import com.rackspace.vehicleinventory.model.VehicleInventorySaveResponse;

import java.io.IOException;

public interface IVehicleInventoryService {

   VehicleInventoryResponse retrieveVehicleInventoryResponse(VehicleInventoryRequest vehicleInventoryRequest) throws VehicleInventoryException, IOException;
   VehicleInventorySaveResponse update(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse add(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse delete(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse deleteLastVehicle() throws IOException;

}

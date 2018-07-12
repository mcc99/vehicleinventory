package com.company.vehicleinventory.interfaces;

import com.company.vehicleinventory.exceptions.VehicleInventoryException;
import com.company.vehicleinventory.model.VehicleInventoryRequest;
import com.company.vehicleinventory.model.VehicleInventoryResponse;
import com.company.vehicleinventory.model.VehicleInventorySaveResponse;

import java.io.IOException;

public interface IVehicleInventoryService {

   VehicleInventoryResponse retrieveVehicleInventoryResponse(VehicleInventoryRequest vehicleInventoryRequest) throws VehicleInventoryException, IOException;
   VehicleInventorySaveResponse update(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse add(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse delete(VehicleInventoryRequest vehicleInventorySaveRequest) throws IOException;
   VehicleInventorySaveResponse deleteLastVehicle() throws IOException;

}

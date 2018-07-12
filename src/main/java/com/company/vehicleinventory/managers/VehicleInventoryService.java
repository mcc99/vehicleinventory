package com.company.vehicleinventory.managers;

import com.company.vehicleinventory.model.VehicleInventoryRequest;
import com.company.vehicleinventory.model.VehicleInventoryResponse;
import com.company.vehicleinventory.model.VehicleInventorySaveResponse;
import com.company.vehicleinventory.persistence.managers.VehicleInventoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;


public class VehicleInventoryService {

    @Autowired
    VehicleInventoryManager vehicleInventoryManager;

    public VehicleInventorySaveResponse update(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        VehicleInventorySaveResponse vehicleInventorySaveResponse = new VehicleInventorySaveResponse();
        vehicleInventorySaveResponse.setStatus(vehicleInventoryManager.updateVehicle(vehicleInventoryRequest));
        return vehicleInventorySaveResponse;
    }

    public VehicleInventorySaveResponse add(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        VehicleInventorySaveResponse vehicleInventorySaveResponse = new VehicleInventorySaveResponse();
        vehicleInventorySaveResponse.setStatus(vehicleInventoryManager.addVehicle(vehicleInventoryRequest));
        return vehicleInventorySaveResponse;
    }

    public VehicleInventorySaveResponse delete(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        VehicleInventorySaveResponse vehicleInventorySaveResponse = new VehicleInventorySaveResponse();
        vehicleInventorySaveResponse.setStatus(vehicleInventoryManager.deleteVehicle(vehicleInventoryRequest));
        return vehicleInventorySaveResponse;
    }

    public VehicleInventorySaveResponse deleteLastVehicle() throws IOException {
        VehicleInventorySaveResponse vehicleInventorySaveResponse = new VehicleInventorySaveResponse();
        vehicleInventorySaveResponse.setStatus(vehicleInventoryManager.deleteLastVehicle());
        return vehicleInventorySaveResponse;
    }

    public VehicleInventoryResponse retrieveVehicleInventoryResponse(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        VehicleInventoryResponse vehicleInventoryResponse = new VehicleInventoryResponse();
        vehicleInventoryResponse.setVehicles(vehicleInventoryManager.searchVehicles(vehicleInventoryRequest));
        return vehicleInventoryResponse;
    }


}








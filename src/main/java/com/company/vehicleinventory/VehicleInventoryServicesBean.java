package com.company.vehicleinventory;


import com.company.vehicleinventory.interfaces.IVehicleInventoryService;
import com.company.vehicleinventory.managers.VehicleInventoryService;
import com.company.vehicleinventory.model.VehicleInventoryRequest;
import com.company.vehicleinventory.model.VehicleInventoryResponse;
import com.company.vehicleinventory.model.VehicleInventorySaveResponse;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import java.io.IOException;


@PermitAll
@Component("vehicleInventoryServicesBean")
public class VehicleInventoryServicesBean implements IVehicleInventoryService {

    @Override
    public VehicleInventoryResponse retrieveVehicleInventoryResponse(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return new VehicleInventoryService().retrieveVehicleInventoryResponse(vehicleInventoryRequest);
    }

    @Override
    public VehicleInventorySaveResponse update(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return new VehicleInventoryService().update(vehicleInventoryRequest);
    }

    @Override
    public VehicleInventorySaveResponse add(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return new VehicleInventoryService().add(vehicleInventoryRequest);
    }

    @Override
    public VehicleInventorySaveResponse delete(VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return new VehicleInventoryService().delete(vehicleInventoryRequest);
    }

    @Override
    public VehicleInventorySaveResponse deleteLastVehicle() throws IOException {
        return new VehicleInventoryService().deleteLastVehicle();
    }

}

package com.company.vehicleinventory.services;

import com.company.vehicleinventory.annotations.VehicleInventorySaveRequestIsValid;
import com.company.vehicleinventory.exceptions.VehicleInventoryError;
import com.company.vehicleinventory.annotations.VehicleInventoryRequestIsValid;
import com.company.vehicleinventory.exceptions.VehicleInventoryException;
import com.company.vehicleinventory.interfaces.IVehicleInventoryService;
import com.company.vehicleinventory.model.VehicleInventoryRequest;
import com.company.vehicleinventory.model.VehicleInventoryResponse;
import com.company.vehicleinventory.model.VehicleInventorySaveResponse;
import com.wordnik.swagger.annotations.ApiParam;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Class representing REST service endpoints for various operations in the application.
 * Given the limited range of the app, an MVC model was not really needed, though good
 * practice typically assumes the app will expand in required functionality and starts
 * out with an MVC paradigm implemented.  In this case there is only one service endpoint
 * class that acts as a controller forwarding requests to nowhere but instead
 * processing them in the class by calling a class delegated to handling the actual business logic.
 *
 * With regard to the responses returned, they are status codes only.  Depending on the front end
 * design of the app, we may instead elect to return the inventory list as it is in the database
 * after given action (add, delete, etc.) has been taken.  This is dependent on the front-end design
 * paradigm however.  Some front-end designs seek to minimize the number of times a database
 * is queries fully for a dataset while others seek to play it safe and want a full refeshed
 * view of the database after each request, esp. when there are multiple concurrent users likely
 * to be accessing or modifying the same data set.
 *
 */

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("/")
@DenyAll
public class VehicleInventoryServiceResource {

    @Autowired
    @Qualifier("vehicleInventoryServicesBean")
    private IVehicleInventoryService vehicleInventoryService;


    @POST
    @Path("inventorysearch")
    @PermitAll
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VehicleInventoryResponse.class),
            @ApiResponse(code = 400, message = "Invalid", response = VehicleInventoryError.class),
            @ApiResponse(code = 401, message = "Not authorized", response = VehicleInventoryError.class),
            @ApiResponse(code = 500, message = "Unhandled exception", response = VehicleInventoryError.class)
    })
    public Response retrieveSearchResults(@Encoded @ApiParam(value = "VehicleInventoryRequest", required = true) @VehicleInventoryRequestIsValid VehicleInventoryRequest vehicleInventoryRequest) throws VehicleInventoryException, IOException {
       return Response.ok().entity(vehicleInventoryService.retrieveVehicleInventoryResponse(vehicleInventoryRequest)).build();
    }

    @POST
    @Path("addvehicle")
    @PermitAll
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VehicleInventorySaveResponse.class),
            @ApiResponse(code = 400, message = "Invalid", response = VehicleInventoryError.class),
            @ApiResponse(code = 401, message = "Not authorized", response = VehicleInventoryError.class),
            @ApiResponse(code = 500, message = "Unhandled exception", response = VehicleInventoryError.class)
    })
    public Response saveVehicle(@Encoded @ApiParam(value = "VehicleInventoryRequest", required = true) @VehicleInventorySaveRequestIsValid VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return Response.ok().entity(vehicleInventoryService.add(vehicleInventoryRequest)).build();
    }

    @POST
    @Path("deletevehicle")
    @PermitAll
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VehicleInventorySaveResponse.class),
            @ApiResponse(code = 400, message = "Invalid", response = VehicleInventoryError.class),
            @ApiResponse(code = 401, message = "Not authorized", response = VehicleInventoryError.class),
            @ApiResponse(code = 500, message = "Unhandled exception", response = VehicleInventoryError.class)
    })
    public Response deleteVehicle(@Encoded @ApiParam(value = "VehicleInventoryRequest", required = true) @VehicleInventorySaveRequestIsValid VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return Response.ok().entity(vehicleInventoryService.delete(vehicleInventoryRequest)).build();
    }

    @POST
    @Path("updatevehicle")
    @PermitAll
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VehicleInventorySaveResponse.class),
            @ApiResponse(code = 400, message = "Invalid", response = VehicleInventoryError.class),
            @ApiResponse(code = 401, message = "Not authorized", response = VehicleInventoryError.class),
            @ApiResponse(code = 500, message = "Unhandled exception", response = VehicleInventoryError.class)
    })
    public Response updateVehicle(@Encoded @ApiParam(value = "VehicleInventoryRequest", required = true) @VehicleInventorySaveRequestIsValid VehicleInventoryRequest vehicleInventoryRequest) throws IOException {
        return Response.ok().entity(vehicleInventoryService.update(vehicleInventoryRequest)).build();
    }

    @GET
    @Path("deletelastvehicle")
    @PermitAll
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VehicleInventorySaveResponse.class),
            @ApiResponse(code = 400, message = "Invalid", response = VehicleInventoryError.class),
            @ApiResponse(code = 401, message = "Not authorized", response = VehicleInventoryError.class),
            @ApiResponse(code = 500, message = "Unhandled exception", response = VehicleInventoryError.class)
    })
    public Response deleteLastVehicle() throws IOException {
        return Response.ok().entity(vehicleInventoryService.deleteLastVehicle()).build();
    }

}

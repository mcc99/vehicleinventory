package com.company.vehicleinventory.persistence.managers;

import com.company.vehicleinventory.constants.VehicleInventoryConstants;
import com.company.vehicleinventory.enums.VehicleInventoryDatabaseStatusCode;
import com.company.vehicleinventory.model.VehicleInventoryRequest;
import com.company.vehicleinventory.persistence.VehicleInventory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Class manages reads/writes to the database of vehicles as well as searches
 */

@Repository
public class VehicleInventoryManager {

    // Normally this would be created and managed in a separate class. Since we have in this example only one
    // DAO manager in the app I am creating it here.
    private static EntityManager entityManager = Persistence.createEntityManagerFactory(VehicleInventoryConstants.PERSISTENCE_UNIT_NAME).createEntityManager();


    /**
     * Deletes vehicle from database based on VIN key value.
     *
     * @param vehicleInventoryRequest
     */
    public VehicleInventoryDatabaseStatusCode deleteVehicle(VehicleInventoryRequest vehicleInventoryRequest) {

        if (vehicleInventoryRequest == null) {
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        VehicleInventory vehicleInventory = new VehicleInventory();
        vehicleInventory.setVin(vehicleInventoryRequest.getVin());
        entityManager.getTransaction().begin();
        entityManager.remove(vehicleInventory);
        entityManager.getTransaction().commit();
        vehicleInventory = entityManager.find(VehicleInventory.class, vehicleInventory);

        if(vehicleInventory != null) {
            // Log failure to do delete here
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        return VehicleInventoryDatabaseStatusCode.DELETED;

    }

    /**
     * Deletes the last vehicle added to the db.
     *
     */
    public VehicleInventoryDatabaseStatusCode deleteLastVehicle() {

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<VehicleInventory> deleteLastVehicleQuery = criteriaBuilder.createCriteriaDelete(VehicleInventory.class);
            Root<VehicleInventory> deleteLastVehicleRoot = deleteLastVehicleQuery.from(VehicleInventory.class);
            deleteLastVehicleQuery.where(criteriaBuilder.greatest(deleteLastVehicleRoot.get("dateAdded")));
            entityManager.createQuery(deleteLastVehicleQuery).executeUpdate();
        } catch (Exception exception) {
            // Log error here
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        return VehicleInventoryDatabaseStatusCode.DELETED;

    }


    /**
     * Update the vehicle based on values found in the input param.  currVin is he VIN of the vehicle as orig.
     * rendered.  vin is the VIN of the vehicle as submitted by the user.  currVin is used to get the vehicle
     * as currently stored while vin is used to set the new VIN value if there is one.
     *
     * @param vehicleInventoryRequest
     */
    public VehicleInventoryDatabaseStatusCode updateVehicle(VehicleInventoryRequest vehicleInventoryRequest) {

        if (vehicleInventoryRequest == null) {
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        VehicleInventory vehicleInventory = new VehicleInventory();
        vehicleInventory.setVin(vehicleInventoryRequest.getCurrVin());
        vehicleInventory = entityManager.find(VehicleInventory.class, vehicleInventory);
        if(vehicleInventory == null) {
            // Log failure to find vehicle here
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        try {
            entityManager.getTransaction().begin();
            vehicleInventory.setVin(vehicleInventoryRequest.getVin());
            vehicleInventory.setMake(vehicleInventoryRequest.getMake());
            vehicleInventory.setModel(vehicleInventoryRequest.getModel());
            vehicleInventory.setYear(vehicleInventoryRequest.getYear());
            vehicleInventory.setUsed(vehicleInventoryRequest.getUsed());
            vehicleInventory.setType(vehicleInventoryRequest.getType());
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            // Log failure to do update here.
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        return VehicleInventoryDatabaseStatusCode.UPDATED;

    }



    /**
     * Persists vehicle information to the database and returns status.
     *
     * @param vehicleInventoryRequest
     */
    public VehicleInventoryDatabaseStatusCode addVehicle(VehicleInventoryRequest vehicleInventoryRequest) {

        if (vehicleInventoryRequest == null) {
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            VehicleInventory vehicleInventory = new VehicleInventory();
            vehicleInventory.setMake(vehicleInventoryRequest.getMake());
            vehicleInventory.setModel(vehicleInventoryRequest.getModel());
            vehicleInventory.setVin(vehicleInventoryRequest.getVin());
            vehicleInventory.setYear(vehicleInventoryRequest.getYear());
            vehicleInventory.setUsed(vehicleInventoryRequest.getUsed());
            vehicleInventory.setType(vehicleInventoryRequest.getType());
            vehicleInventory.setDateAdded(Calendar.getInstance());
            entityTransaction.commit();
        } catch (Exception exception) {
            // Log error here
            return VehicleInventoryDatabaseStatusCode.FAILED;
        }

        return VehicleInventoryDatabaseStatusCode.ADDED;
    }

    /**
     * Returns List of VehicleInventory objects based on values submitted via a search form.
     * The search values would be represented by a VehicleInventoryRequest and based on desired
     * approach would include automatic wildcarding, etc.
     *
     * @param vehicleInventoryRequest
     */
    public List<VehicleInventory> searchVehicles(VehicleInventoryRequest vehicleInventoryRequest) {

        if (vehicleInventoryRequest == null) {
            return null; // In fact I'd return all vehicles since a search with no criteria should return all of the item generally.
        }

        // Search implemented here.

        return new ArrayList<VehicleInventory>();
    }

}

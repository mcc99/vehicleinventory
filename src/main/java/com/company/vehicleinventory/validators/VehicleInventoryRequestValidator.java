package com.company.vehicleinventory.validators;

import com.company.vehicleinventory.annotations.VehicleInventoryRequestIsValid;
import com.company.vehicleinventory.model.VehicleInventoryRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Request validator.  Further conditions could be added, such as checking for values
 * in each field.  That is ultimately desirable given the data model marks all fields
 * as being required.  Generally, the data req'ts should be enforced at the front end as well as the back end.
 */
public class VehicleInventoryRequestValidator implements ConstraintValidator<VehicleInventoryRequestIsValid, VehicleInventoryRequest> {

    @Override
    public void initialize(VehicleInventoryRequestIsValid vehicleInventoryRequestIsValid) {
    }

   @Override
   public boolean isValid(VehicleInventoryRequest vehicleInventoryRequest, ConstraintValidatorContext constraintValidatorContext) {
      if(vehicleInventoryRequest == null) {
          return false;
      }
    return true;
   }

}

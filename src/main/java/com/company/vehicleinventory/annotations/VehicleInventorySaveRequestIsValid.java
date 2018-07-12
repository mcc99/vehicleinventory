package com.company.vehicleinventory.annotations;

import com.company.vehicleinventory.validators.VehicleInventorySaveRequestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {VehicleInventorySaveRequestValidator.class})
@Documented
public @interface VehicleInventorySaveRequestIsValid {

    String message() default "Request is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

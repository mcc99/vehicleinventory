package com.company.vehicleinventory.annotations;

import com.company.vehicleinventory.validators.VehicleInventoryRequestValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;


@Documented
@Constraint(validatedBy = VehicleInventoryRequestValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VehicleInventoryRequestIsValid {
    String message() default "Request is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
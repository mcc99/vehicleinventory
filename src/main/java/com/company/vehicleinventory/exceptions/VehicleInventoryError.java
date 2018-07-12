package com.company.vehicleinventory.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represnts error codes embedded in a custom exception.  Not used at the moment but this is a common practice.
 */
@XmlRootElement
public class VehicleInventoryError {

    private String code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}

package com.mcmxc.validator;

public class TruckNumberValidator {

    public TruckNumberValidator() {
    }

    public static boolean validateTruckNumber(String number) {
        if(!number.matches("(?ui)^[А-ЯA-Z0-9]{7}$")) { //only letters and numbers (7 times)
            return false;
        } else if(!number.matches("(?ui)^[0-9]*[А-ЯA-Z]{1}[0-9]*[А-ЯA-Z]{1}[0-9]*$")) { //2 letters anywhere
            return false;
        } else {
            return true;
        }
    }
}

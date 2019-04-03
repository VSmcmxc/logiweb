package com.mcmxc.validator;

import com.mcmxc.entities.Truck;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TruckValidator implements Validator {

    private static final String TRUCK_PATTERN = "[a-zA-Z]{2}\\d{5}";

    @Override
    public boolean supports(Class<?> aClass) {
        return Truck.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Truck truck = (Truck)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "NotEmpty.truckForm.number");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacity", "NotEmpty.truckForm.capacity");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shiftSize", "NotEmpty.truckForm.shiftSize");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city.name", "NotEmpty.truckForm.city");
        if (!truck.getNumber().matches(TRUCK_PATTERN))
            errors.rejectValue("number", "Pattern.truckForm.number");
        if (truck.getTruckSize() <= 0 || truck.getTruckSize() > 70)
            errors.rejectValue("capacity", "Pattern.truckForm.capacity");
        if (truck.getTruckShift() <= 0 || truck.getTruckShift() > 6 )
            errors.rejectValue("shiftSize", "Pattern.truckForm.shiftSize");
    }
}

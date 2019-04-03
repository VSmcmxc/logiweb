package com.mcmxc.entities.enums;

public enum DriverStatus {
    VACATION("VACATION"),
    DRIVING("DRIVING"),
    FREE("FREE"),
    SECOND_DRIVER("SECOND_DRIVER");


    final String driverStatus;

    DriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    @Override
    public String toString() {
        return this.driverStatus;
    }
}
package com.mcmxc.entities.enums;

public enum TruckStatus {
    MULFUNCTIONED("MULFUNCTIONED"),
    WORKED("WORKED");

    final String truckStatus;

    TruckStatus(String truckStatus) {
        this.truckStatus = truckStatus;
    }

    public String getTruckStatus() {
        return truckStatus;
    }

    @Override
    public String toString() {
        return this.truckStatus;
    }
}
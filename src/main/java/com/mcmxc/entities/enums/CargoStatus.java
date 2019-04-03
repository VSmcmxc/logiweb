package com.mcmxc.entities.enums;

public enum  CargoStatus {

    WAITING("WAITING"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED");

    final String cargoStatus;

    CargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    @Override
    public String toString() {
        return this.cargoStatus;
    }
}

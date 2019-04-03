package com.mcmxc.entities.enums;

public enum  TypeRoute {
    PICKUP("PICKUP"),
    UNLOAD("UNLOAD");

    final String typeRoute;

    TypeRoute(String typeRoute) {
        this.typeRoute = typeRoute;
    }

    public String getTypeRoute() {
        return typeRoute;
    }

    @Override
    public String toString() {
        return this.typeRoute;
    }
}

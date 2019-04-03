package com.mcmxc.entities.enums;

public enum UserRole {
    ROLE_DISPATCHER("ROLE_DISPATCHER"),
    ROLE_DRIVER("ROLE_DRIVER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_OTHER("ROLE_OTHER");

    final String userRole;

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return this.userRole;
    }
}
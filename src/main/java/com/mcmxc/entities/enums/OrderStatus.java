package com.mcmxc.entities.enums;

public enum OrderStatus {
    FINISHED("FINISHED"),
    NOT_FINISHED("NOT_FINISHED");

    final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return this.orderStatus;
    }
}
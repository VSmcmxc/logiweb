package com.mcmxc.entities;


import com.mcmxc.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "orders", schema = "logiweb")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private int id;

    @Basic
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_current_truck")
    private Truck currentTruck;


    @OneToMany(mappedBy = "currentOrder")
    private Set<RoutePoint> routePoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Truck getCurrentTruck() {
        return currentTruck;
    }

    public void setCurrentTruck(Truck currentTruck) {
        this.currentTruck = currentTruck;
    }

    public Set<RoutePoint> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(Set<RoutePoint> routePoints) {
        this.routePoints = routePoints;
    }
}

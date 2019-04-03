package com.mcmxc.entities;

import com.mcmxc.entities.enums.CargoStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cargo", schema = "logiweb")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id", unique = true, nullable = false)
    private int id;

    @Basic
    @Column(name = "cargo_name", nullable = false, length = 255)
    private String cargoName;

    @Basic
    @Column(name = "cargo_weight", nullable = false)
    private double weight;

    @Column(name = "cargo_status", nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private CargoStatus status;

    @ManyToOne
    @JoinColumn(name = "cargo_point", referencedColumnName = "route_id", nullable = false)
    private RoutePoint routePoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public CargoStatus getStatus() {
        return status;
    }

    public void setStatus(CargoStatus status) {
        this.status = status;
    }

    public RoutePoint getRoutePoint() {
        return routePoint;
    }

    public void setRoutePoint(RoutePoint routePoint) {
        this.routePoint = routePoint;
    }
}

package com.mcmxc.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "city", schema = "logiweb")
public class City implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "city_name", nullable = false, length = 255, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentCity")
    private Set<Truck> trucksInCity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentCity")
    private Set<Driver> driversInCity;

      @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentCity")
    private Set<RoutePoint> routePoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Truck> getTrucksInCity() {
        return trucksInCity;
    }

    public void setTrucksInCity(Set<Truck> trucksInCity) {
        this.trucksInCity = trucksInCity;
    }

    public Set<Driver> getDriversInCity() {
        return driversInCity;
    }

    public void setDriversInCity(Set<Driver> driversInCity) {
        this.driversInCity = driversInCity;
    }

    public Set<RoutePoint> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(Set<RoutePoint> routePoints) {
        this.routePoints = routePoints;
    }

    @Override
    public String toString() {
        return this.name;
    }
}


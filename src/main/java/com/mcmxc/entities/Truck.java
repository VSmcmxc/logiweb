package com.mcmxc.entities;

import com.mcmxc.entities.enums.TruckStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "truck", schema = "logiweb")
public class Truck implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truck_id", unique = true, nullable = false)
    private int id;

    @Column(name = "truck_number", nullable = false, length = 7)
    private String number;

    @Basic
    @Column(name = "truck_driver_capacity", nullable = false)
    private int driverCapacity;

    @Column(name = "truck_capacity", nullable = false)
    private double truckSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "truck_status", nullable = false)
    private TruckStatus truckStatus;

    @Basic
    @Column(name = "truck_shift_size", nullable = false)
    private int truckShift;

    @ManyToOne
    @JoinColumn(name = "truck_current_city", referencedColumnName = "city_id", nullable = false)
    private City currentCity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currentTruck")
    private Set<Driver> driversInTruck;

    @OneToOne(mappedBy = "currentTruck", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Order currentOrder;

    @Transient
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getDriverCapacity() {
        return driverCapacity;
    }

    public void setDriverCapacity(int driverCapacity) {
        this.driverCapacity = driverCapacity;
    }

    public double getTruckSize() {
        return truckSize;
    }

    public void setTruckSize(double truckSize) {
        this.truckSize = truckSize;
    }

    public TruckStatus getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(TruckStatus truckStatus) {
        this.truckStatus = truckStatus;
    }

    public int getTruckShift() {
        return truckShift;
    }

    public void setTruckShift(int truckShift) {
        this.truckShift = truckShift;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Set<Driver> getDriversInTruck() {
        return driversInTruck;
    }

    public void setDriversInTruck(Set<Driver> driversInTruck) {
        this.driversInTruck = driversInTruck;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", driverCapacity=" + driverCapacity +
                ", truckSize=" + truckSize +
                ", truckStatus=" + truckStatus +
                ", truckShift=" + truckShift +
                ", currentCity=" + currentCity +
                '}';
    }
}

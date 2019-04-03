package com.mcmxc.entities;

import com.mcmxc.entities.enums.DriverStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "driver", schema = "logiweb")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", unique = true, nullable = false)
    private int id;

    @Basic
    @Column(name = "driver_first_name", nullable = false, length = 255)
    private String firstName;

    @Basic
    @Column(name = "driver_last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "driver_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @Basic
    @Column(name = "drivers_hours_current_month", length = 255)
    private Integer hoursInMonth;

    @ManyToOne
    @JoinColumn(name = "driver_current_city", referencedColumnName = "city_id")
    private City currentCity;

    @ManyToOne
    @JoinColumn(name = "driver_current_truck", referencedColumnName = "truck_id")
    private Truck currentTruck;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private Set<DriverJournal> driverJournals;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_driver")
    private User driverUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public Integer getHoursInMonth() {
        return hoursInMonth;
    }


    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public Truck getCurrentTruck() {
        return currentTruck;
    }

    public void setCurrentTruck(Truck currentTruck) {
        this.currentTruck = currentTruck;
    }

    public Set<DriverJournal> getDriverJournals() {
        return driverJournals;
    }

    public void setDriverJournals(Set<DriverJournal> driverJournals) {
        this.driverJournals = driverJournals;
    }

    public void setHoursInMonth(Integer hoursInMonth) {
        this.hoursInMonth = hoursInMonth;
    }

    public User getDriverUser() {
        return driverUser;
    }

    public void setDriverUser(User driverUser) {
        this.driverUser = driverUser;
    }
}
